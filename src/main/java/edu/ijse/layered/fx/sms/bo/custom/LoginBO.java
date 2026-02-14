package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.LoginDTO;

public interface LoginBO {

    LoginDTO findByUsernameAndPassword(String username, String password) throws Exception;

}
