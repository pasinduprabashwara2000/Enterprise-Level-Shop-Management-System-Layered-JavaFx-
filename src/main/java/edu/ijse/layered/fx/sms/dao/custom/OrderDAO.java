package edu.ijse.layered.fx.sms.dao.custom;

import edu.ijse.layered.fx.sms.dto.OrderDTO;

public interface OrderDAO {

    int placeOrder(OrderDTO orderDTO) throws Exception;
    void printInvoice(Integer orderId) throws Exception;

}
