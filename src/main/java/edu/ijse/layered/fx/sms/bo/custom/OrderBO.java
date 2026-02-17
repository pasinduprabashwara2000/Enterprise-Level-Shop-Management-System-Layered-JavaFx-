package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.OrderDTO;

public interface OrderBO {

    int placeOrder(OrderDTO orderDTO) throws Exception;
    void printInvoice(Integer orderId) throws Exception;

}
