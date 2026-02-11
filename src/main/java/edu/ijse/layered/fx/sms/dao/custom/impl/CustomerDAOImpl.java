package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.CustomerDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.CustomerEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String save(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO Customer (name,phone,email,loyaltyCode) VALUES (?,?,?,?)",
                customerEntity.getName(),
                customerEntity.getPhone(),
                customerEntity.getEmail(),
                customerEntity.getLoyaltyCode());
    }

    @Override
    public String update(CustomerEntity customerEntity) throws Exception {
        return CrudUtil.execute("UPDATE Customer SET name=?, phone=?, email=?, loyaltyCode=? WHERE customerId=?",
                customerEntity.getName(),
                customerEntity.getPhone(),
                customerEntity.getEmail(),
                customerEntity.getLoyaltyCode(),
                customerEntity.getCustomerId());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Customer WHERE customerId=?",
                    id);
    }

    @Override
    public CustomerEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM Customer WHERE customerId=?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM Customer");
    }
}
