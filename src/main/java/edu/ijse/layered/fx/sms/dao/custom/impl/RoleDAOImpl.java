package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.RoleDAO;
import edu.ijse.layered.fx.sms.entity.RoleEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        return CrudUtil.execute("DELETE FROM Role WHERE roleID=?", id);
    }

    @Override
    public RoleEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Role WHERE roleID=?", id);
        if(rst.next()){
            return new RoleEntity(
                    rst.getString("roleID"),
                    rst.getString("name"),
                    rst.getString("userID")
            );
        }
        return null;
    }

    @Override
    public ArrayList<RoleEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Role");
        ArrayList <RoleEntity> roleEntities = new ArrayList<>();

        while (rst.next()){
            roleEntities.add(new RoleEntity(
                    rst.getString("roleID"),
                    rst.getString("name"),
                    rst.getString("userID")
            ));
        }
        return roleEntities;
    }
}
