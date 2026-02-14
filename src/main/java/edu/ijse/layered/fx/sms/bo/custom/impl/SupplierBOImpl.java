package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.SupplierBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.SupplierDAO;
import edu.ijse.layered.fx.sms.dto.SupplierDTO;
import edu.ijse.layered.fx.sms.entity.SupplierEntity;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public String save(SupplierDTO supplierDTO) throws Exception {

        SupplierEntity supplierEntity = new SupplierEntity(
                supplierDTO.getSupplierID(),
                supplierDTO.getName(),
                supplierDTO.getContactPerson(),
                supplierDTO.getPhone(),
                supplierDTO.getEmail(),
                supplierDTO.getAddress()
        );

        return Boolean.parseBoolean(supplierDAO.save(supplierEntity)) ? "Supplier Save Successfully" : "Supplier Save Failed";

    }

    @Override
    public String update(SupplierDTO supplierDTO) throws Exception {

        SupplierEntity supplierEntity = new SupplierEntity(
                supplierDTO.getSupplierID(),
                supplierDTO.getName(),
                supplierDTO.getContactPerson(),
                supplierDTO.getPhone(),
                supplierDTO.getEmail(),
                supplierDTO.getAddress()
        );

        return Boolean.parseBoolean(supplierDAO.update(supplierEntity)) ? "Supplier Update Successfully" : "Supplier Update Failed";

    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(supplierDAO.delete(id)) ? "Supplier Delete Successfully" : "Supplier Delete Failed";
    }

    @Override
    public SupplierDTO search(String id) throws Exception {
        SupplierEntity supplierEntity = supplierDAO.search(id);
        return new SupplierDTO(
                supplierEntity.getSupplierID(),
                supplierEntity.getName(),
                supplierEntity.getContactPerson(),
                supplierEntity.getPhone(),
                supplierEntity.getEmail(),
                supplierEntity.getAddress()
        );
    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws Exception {

        ArrayList <SupplierEntity> supplierEntities = supplierDAO.getAll();
        ArrayList <SupplierDTO> supplierDTOS = new ArrayList<>();

        for (SupplierEntity supplierEntity : supplierEntities){
            supplierDTOS.add(new SupplierDTO(supplierEntity.getSupplierID(),
                supplierEntity.getName(),
                supplierEntity.getContactPerson(),
                supplierEntity.getPhone(),
                supplierEntity.getEmail(),
                supplierEntity.getAddress())
            );
        }

        return supplierDTOS;
    }
}
