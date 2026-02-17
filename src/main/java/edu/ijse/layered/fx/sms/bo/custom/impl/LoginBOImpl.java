package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.LoginBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.LoginDAO;
import edu.ijse.layered.fx.sms.dto.LoginDTO;
import edu.ijse.layered.fx.sms.entity.LoginEntity;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    @Override
    public LoginDTO findByUsernameAndPassword(String username, String password) throws Exception {
        LoginEntity loginEntity = loginDAO.findByUsernameAndPassword(username,password);
        return new LoginDTO(
                loginEntity.getUserName(),
                loginEntity.getPassword(),
                null
        );
    }
}
