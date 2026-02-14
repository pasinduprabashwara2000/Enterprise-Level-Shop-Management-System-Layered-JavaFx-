package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.UserDAO;
import edu.ijse.layered.fx.sms.entity.UserEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    @Override
    public String save(UserEntity userEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO User (userName, password, active, createdAt) VALUES (?,?,?,?)",
                userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getActive(),
                userEntity.getCreatedAt());
    }

    @Override
    public String update(UserEntity userEntity) throws Exception {
        return CrudUtil.execute("UPDATE User SET userName=?, password=?, active=?, createdAt=? WHERE userID=?",
                userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getActive(),
                userEntity.getCreatedAt(),
                userEntity.getUserID());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM User WHERE userID=?", id);
    }

    @Override
    public UserEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM User WHERE userID=?", id);
        return new UserEntity(
                rst.getString("userID"),
                rst.getString("userName"),
                rst.getString("password"),
                rst.getString("active"),
                rst.getDate("createdAt").toLocalDate()
        );
    }

    @Override
    public ArrayList<UserEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM User");
        ArrayList <UserEntity> userEntities = new ArrayList<>();

        while (rst.next()){
            userEntities.add(new UserEntity(
                    rst.getString("userID"),
                    rst.getString("userName"),
                    rst.getString("password"),
                    rst.getString("active"),
                    rst.getDate("createdAt").toLocalDate()
            ));
        }
        return userEntities;
    }
}
