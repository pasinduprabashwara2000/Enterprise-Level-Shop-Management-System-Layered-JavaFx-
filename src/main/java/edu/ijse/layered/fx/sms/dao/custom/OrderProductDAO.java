package edu.ijse.layered.fx.sms.dao.custom;

import edu.ijse.layered.fx.sms.dto.OrderProductDTO;
import java.util.List;

public interface OrderProductDAO {

    boolean saveProductsToList(int orderId, List<OrderProductDTO> dtoList) throws Exception;

}
