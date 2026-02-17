package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.OrderProductBO;
import edu.ijse.layered.fx.sms.dto.OrderProductDTO;
import java.util.List;

public class OrderProductBOImpl implements OrderProductBO {

    @Override
    public boolean saveProductsToList(int orderId, List<OrderProductDTO> dtoList) throws Exception {
        return false;
    }
}
