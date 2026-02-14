package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.OrderProductDAO;
import edu.ijse.layered.fx.sms.dao.custom.ProductDAO;
import edu.ijse.layered.fx.sms.dto.OrderProductDTO;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.util.List;

public class OrderProductDAOImpl implements OrderProductDAO {

    private final ProductDAO productDAO = (ProductDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRODUCT);

    @Override
    public boolean saveProductsToList(int orderId, List<OrderProductDTO> dtoList) throws Exception {

        for (OrderProductDTO orderProductDTO : dtoList) {

            boolean isInserted = CrudUtil.execute(
                    "INSERT INTO order_products (order_id, product_id, qty, price) VALUES (?,?,?,?)",
                    orderId,
                    orderProductDTO.getProductId(),
                    orderProductDTO.getQty(),
                    orderProductDTO.getPrice()
            );

            if (!isInserted) {
                throw new Exception("Something Went Wrong Inserting Data");
            }

            boolean isQtyUpdated = productDAO.decreaseProductQTY(
                    orderProductDTO.getProductId(),
                    orderProductDTO.getQty()
            );

            if (!isQtyUpdated) {
                throw new Exception("Something Went Wrong Reducing QTY");
            }
        }

        return true;
    }
}
