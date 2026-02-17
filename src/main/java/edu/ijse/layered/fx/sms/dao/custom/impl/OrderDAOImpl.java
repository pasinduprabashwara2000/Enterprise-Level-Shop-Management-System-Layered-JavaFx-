package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.OrderDAO;
import edu.ijse.layered.fx.sms.dao.custom.OrderProductDAO;
import edu.ijse.layered.fx.sms.db.DBConnection;
import edu.ijse.layered.fx.sms.dto.OrderDTO;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {

    private OrderProductDAO orderProductDAO = new OrderProductDAOImpl();

    @Override
    public int placeOrder(OrderDTO orderDTO) throws Exception {

        Connection conn = DBConnection.getDbConnection().getConnection();

        try {
            conn.setAutoCommit(false);

            // Save Order
            boolean isSaved = CrudUtil.execute(
                    "INSERT INTO orders (date, customer_id) VALUES (?, ?)",
                    orderDTO.getOrderDate(),
                    orderDTO.getCustomerId()
            );

            if (!isSaved) {
                throw new Exception("Error inserting order");
            }

            // Get Last Inserted ID (better: generated keys)
            ResultSet rst = CrudUtil.execute(
                    "SELECT LAST_INSERT_ID() AS id"
            );

            if (!rst.next()) {
                throw new Exception("Error getting order id");
            }

            int orderId = rst.getInt("id");

            // Save Order Items
            boolean isItemsSaved = orderProductDAO.saveProductsToList(
                    orderId,
                    orderDTO.getOrderItems()
            );

            if (!isItemsSaved) {
                throw new Exception("Error saving order items");
            }

            conn.commit();
            return orderId;

        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    @Override
    public void printInvoice(Integer orderId) throws SQLException, JRException, ClassNotFoundException {

        Connection conn = DBConnection.getDbConnection().getConnection();
        InputStream inputStream = getClass().getResourceAsStream("/edu/ijse/layered/fx/sms/reports/invoice.jrxml");
        JasperReport jr = JasperCompileManager.compileReport(inputStream);

        Map<String, Object> params = new HashMap<>();
        params.put("ORDER_ID", orderId);

        JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);
        JasperViewer.viewReport(jp, false);

    }
}
