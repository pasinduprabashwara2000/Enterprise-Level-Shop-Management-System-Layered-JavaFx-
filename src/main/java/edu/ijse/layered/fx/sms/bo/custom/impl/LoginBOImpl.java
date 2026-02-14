package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.LoginBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.LoginDAO;
import edu.ijse.layered.fx.sms.dto.LoginDTO;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    @Override
    public LoginDTO findByUsernameAndPassword(String username, String password) throws Exception {
        return loginDAO.findByUsernameAndPassword(username, password);
    }
}
