package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.LoginDAO;
import edu.ijse.layered.fx.sms.entity.LoginEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public LoginEntity findByUsernameAndPassword(String username, String password) throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT User.userName, User.password, Role.name\n" +
                "FROM User\n" +
                "JOIN Role\n" +
                "ON User.userID = Role.userID\n" +
                "WHERE User.userName = ? AND User.password = ?;");

        if(rst.next()){
            LoginEntity loginEntity = new LoginEntity(
                    rst.getString("userName"),
                    rst.getString("password"),
                    rst.getString("name"));
            return loginEntity;

        }

        return null;

    }
}
