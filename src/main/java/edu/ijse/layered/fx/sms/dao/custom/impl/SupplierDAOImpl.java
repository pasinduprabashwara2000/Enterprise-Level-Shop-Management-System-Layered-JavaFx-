package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.SupplierDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.SupplierEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public String save(SupplierEntity supplierEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO Supplier (name, contactPerson, phone, email, address) VALUES(?,?,?,?,?)",
                supplierEntity.getName(),
                supplierEntity.getContactPerson(),
                supplierEntity.getPhone(),
                supplierEntity.getEmail(),
                supplierEntity.getAddress());
    }

    @Override
    public String update(SupplierEntity supplierEntity) throws Exception {
        return CrudUtil.execute("UPDATE Supplier SET name=?, contactPerson=?, phone=?, email=?, address=? WHERE supplierID=?",
                supplierEntity.getName(),
                supplierEntity.getContactPerson(),
                supplierEntity.getPhone(),
                supplierEntity.getEmail(),
                supplierEntity.getAddress(),
                supplierEntity.getSupplierID());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Supplier WHERE supplierID=?",
                id);
    }

    @Override
    public SupplierEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM Supplier WHERE supplierID=?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM Supplier");
    }
}
