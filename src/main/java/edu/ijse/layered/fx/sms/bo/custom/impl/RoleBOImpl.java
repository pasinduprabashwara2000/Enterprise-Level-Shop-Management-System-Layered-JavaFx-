package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.RoleBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.RoleDAO;
import edu.ijse.layered.fx.sms.dto.RoleDTO;
import edu.ijse.layered.fx.sms.entity.RoleEntity;
import java.util.ArrayList;

public class RoleBOImpl implements RoleBO {

    RoleDAO roleDAO = (RoleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROLE);

    @Override
    public String save(RoleDTO roleDTO) throws Exception {

        RoleEntity roleEntity = new RoleEntity(
                roleDTO.getRoleID(),
                roleDTO.getName(),
                roleDTO.getUserID()
        );

        return Boolean.parseBoolean(roleDAO.save(roleEntity)) ? "Role Save Successfully" : "Role Save Failed";
    }

    @Override
    public String update(RoleDTO roleDTO) throws Exception {

        RoleEntity roleEntity = new RoleEntity(
                roleDTO.getRoleID(),
                roleDTO.getName(),
                roleDTO.getUserID()
        );

        return Boolean.parseBoolean(roleDAO.update(roleEntity)) ? "Role Update Successfully" : "Role Update Failed";
    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(roleDAO.delete(id)) ? "Role Delete Successfully" : "Role Delete Failed";
    }

    @Override
    public RoleDTO search(String id) throws Exception {
        RoleEntity roleEntity = roleDAO.search(id);
        return new RoleDTO(
                roleEntity.getRoleID(),
                roleEntity.getName(),
                roleEntity.getUserID()
        );
    }

    @Override
    public ArrayList<RoleDTO> getAll() throws Exception {
        ArrayList <RoleEntity> roleEntities = roleDAO.getAll();
        ArrayList <RoleDTO> roleDTOS = new ArrayList<>();

        for (RoleEntity roleEntity : roleEntities){
            roleDTOS.add(new RoleDTO(
                    roleEntity.getRoleID(),
                    roleEntity.getName(),
                    roleEntity.getUserID()
            ));
        }

        return roleDTOS;
    }
}
