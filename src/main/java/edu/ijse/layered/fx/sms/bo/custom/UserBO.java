package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.UserDTO;

import java.util.ArrayList;

public interface UserBO {

    String save(UserDTO userDTO) throws Exception;
    String update(UserDTO userDTO) throws Exception;
    String delete(String id) throws Exception;
    UserDTO search(String id) throws Exception;
    ArrayList<UserDTO> getAll() throws Exception;

}
