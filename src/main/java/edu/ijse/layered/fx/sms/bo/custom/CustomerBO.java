package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.CustomerDTO;
import java.util.ArrayList;

public interface CustomerBO {

    String save(CustomerDTO customerDTO) throws Exception;
    String update(CustomerDTO customerDTO) throws Exception;
    String delete(String id) throws Exception;
    CustomerDTO search(String id) throws Exception;
    ArrayList<CustomerDTO> getAll() throws Exception;

}
