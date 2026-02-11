package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.PurchaseOrderDTO;

import java.util.ArrayList;

public interface PurchaseOrderBO {

    String save(PurchaseOrderDTO purchaseOrderDTO) throws Exception;
    String update(PurchaseOrderDTO purchaseOrderDTO) throws Exception;
    String delete(String id) throws Exception;
    PurchaseOrderDTO search(String id) throws Exception;
    ArrayList<PurchaseOrderDTO> getAll() throws Exception;

}
