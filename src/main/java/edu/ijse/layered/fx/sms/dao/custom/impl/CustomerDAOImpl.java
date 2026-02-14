package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.CustomerDAO;
import edu.ijse.layered.fx.sms.entity.CustomerEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        return CrudUtil.execute("DELETE FROM Customer WHERE customerId=?", id);
    }

    @Override
    public CustomerEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE customerId=?", id);
            if (rst.next()){
                return new CustomerEntity(
                        rst.getString("customerId"),
                        rst.getString("name"),
                        rst.getInt("phone"),
                        rst.getString("email"),
                        rst.getString("loyaltyCode")
                );
            }

            return null;

    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList <CustomerEntity> customerEntities = new ArrayList<>();

        while (rst.next()){
             customerEntities.add(new CustomerEntity(
                     rst.getString("customerId"),
                     rst.getString("name"),
                     rst.getInt("phone"),
                     rst.getString("email"),
                     rst.getString("loyaltyCode")
             ));
        }

        return customerEntities;

    }
}
