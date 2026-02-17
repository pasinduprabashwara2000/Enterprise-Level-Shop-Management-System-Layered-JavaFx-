package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.OrderBO;
import edu.ijse.layered.fx.sms.dto.OrderDTO;

public class OrderBOImpl implements OrderBO {

    @Override
    public int placeOrder(OrderDTO orderDTO) throws Exception {
        return 0;
    }

    @Override
    public void printInvoice(Integer orderId) throws Exception {

    }
}
