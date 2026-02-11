package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.RoleDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.RoleEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class RoleDAOImpl implements RoleDAO {

    @Override
    public String save(RoleEntity roleEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO Role (name, userID) VALUES (?, ?)",
                roleEntity.getName(),
                roleEntity.getUserID());
    }

    @Override
    public String update(RoleEntity roleEntity) throws Exception {
        return CrudUtil.execute("UPDATE Role SET name=?, userID=? WHERE roleID=?",
                roleEntity.getName(),
                roleEntity.getUserID(),
                roleEntity.getRoleID());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Role WHERE roleID=?",
                id);
    }

    @Override
    public RoleEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM Role WHERE roleID=?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM Role");
    }
}
