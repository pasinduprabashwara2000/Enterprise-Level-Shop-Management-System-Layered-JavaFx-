package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.OrderProductDTO;
import java.util.List;

public interface OrderProductBO {

    boolean saveProductsToList(int orderId, List<OrderProductDTO> dtoList) throws Exception;

}
