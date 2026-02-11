package edu.ijse.layered.fx.sms.dao.custom;

import edu.ijse.layered.fx.sms.dao.SuperDAO;
import edu.ijse.layered.fx.sms.entity.LoginEntity;

public interface LoginDAO extends SuperDAO {

    LoginEntity findByUsernameAndPassword(String username, String password) throws Exception;

}
