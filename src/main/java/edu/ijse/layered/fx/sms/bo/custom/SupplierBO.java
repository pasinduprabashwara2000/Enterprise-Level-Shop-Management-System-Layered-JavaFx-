package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.SupplierDTO;

import java.util.ArrayList;

public interface SupplierBO {

    String save(SupplierDTO supplierDTO) throws Exception;
    String update(SupplierDTO supplierDTO) throws Exception;
    String delete(String id) throws Exception;
    SupplierDTO search(String id) throws Exception;
    ArrayList<SupplierDTO> getAll() throws Exception;

}
