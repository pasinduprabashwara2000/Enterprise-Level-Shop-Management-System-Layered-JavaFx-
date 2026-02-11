package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.UserBO;
import edu.ijse.layered.fx.sms.dto.UserDTO;

import java.util.ArrayList;

public class UserBOImpl implements UserBO {

    @Override
    public String save(UserDTO userDTO) throws Exception {
        return "";
    }

    @Override
    public String update(UserDTO userDTO) throws Exception {
        return "";
    }

    @Override
    public String delete(String id) throws Exception {
        return "";
    }

    @Override
    public UserDTO search(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAll() throws Exception {
        return null;
    }
}
