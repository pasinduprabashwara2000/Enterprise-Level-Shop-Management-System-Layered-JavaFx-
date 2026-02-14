package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.OrderDAO;
import edu.ijse.layered.fx.sms.dao.custom.OrderProductDAO;
import edu.ijse.layered.fx.sms.db.DBConnection;
import edu.ijse.layered.fx.sms.dto.OrderDTO;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.Connection;
import java.sql.ResultSet;

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
}
