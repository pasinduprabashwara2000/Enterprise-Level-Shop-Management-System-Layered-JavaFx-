package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.CustomerBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.CustomerDAO;
import edu.ijse.layered.fx.sms.dto.CustomerDTO;
import edu.ijse.layered.fx.sms.entity.CustomerEntity;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public String save(CustomerDTO customerDTO) throws Exception {

        CustomerEntity customerEntity = new CustomerEntity(
            customerDTO.getCustomerId(),
            customerDTO.getName(),
            customerDTO.getPhone(),
            customerDTO.getEmail(),
            customerDTO.getLoyaltyCode()
        );

        return Boolean.parseBoolean(customerDAO.save(customerEntity)) ? "Customer Save Successfully" : "Customer Save Failed";

    }

    @Override
    public String update(CustomerDTO customerDTO) throws Exception {

        CustomerEntity customerEntity = new CustomerEntity(
                customerDTO.getCustomerId(),
                customerDTO.getName(),
                customerDTO.getPhone(),
                customerDTO.getEmail(),
                customerDTO.getLoyaltyCode()
        );

        return Boolean.parseBoolean(customerDAO.update(customerEntity)) ? "Customer Update Successfully" : "Customer Updated Failed";
    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(customerDAO.delete(id)) ? "Customer Deleted Successfully" : "Customer Deleted Failed";
    }

    @Override
    public CustomerDTO search(String id) throws Exception {
        CustomerEntity customerEntity = customerDAO.search(id);
        return new CustomerDTO(
                customerEntity.getCustomerId(),
                customerEntity.getName(),
                customerEntity.getPhone(),
                customerEntity.getEmail(),
                customerEntity.getLoyaltyCode()
        );
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        ArrayList <CustomerEntity> customerEntities = customerDAO.getAll();
        ArrayList <CustomerDTO> customerDTOS = new ArrayList<>();

        for (CustomerEntity customerEntity : customerEntities){
            customerDTOS.add(new CustomerDTO(
                    customerEntity.getCustomerId(),
                    customerEntity.getName(),
                    customerEntity.getPhone(),
                    customerEntity.getEmail(),
                    customerEntity.getLoyaltyCode()
            ));
        }

        return customerDTOS;
    }
}
