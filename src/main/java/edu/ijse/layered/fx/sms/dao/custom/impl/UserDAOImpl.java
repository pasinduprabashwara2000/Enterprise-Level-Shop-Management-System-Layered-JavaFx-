package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.UserDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.UserEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

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
        return CrudUtil.execute("DELETE FROM User WHERE userID=?",
                id);
    }

    @Override
    public UserEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM User WHERE userID=?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM User");
    }
}
