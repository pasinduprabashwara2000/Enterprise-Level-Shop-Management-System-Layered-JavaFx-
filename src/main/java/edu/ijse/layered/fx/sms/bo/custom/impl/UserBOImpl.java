package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.UserBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.UserDAO;
import edu.ijse.layered.fx.sms.dto.UserDTO;
import edu.ijse.layered.fx.sms.entity.UserEntity;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public String save(UserDTO userDTO) throws Exception {

        UserEntity userEntity = new UserEntity(
                userDTO.getUserID(),
                userDTO.getUserName(),
                userDTO.getPassword(),
                userDTO.getActive(),
                userDTO.getCreatedAt()
        );

        return Boolean.parseBoolean(userDAO.save(userEntity)) ? "User Save Successfully" : "User Save Failed";
    }

    @Override
    public String update(UserDTO userDTO) throws Exception {

        UserEntity userEntity = new UserEntity(
                userDTO.getUserID(),
                userDTO.getUserName(),
                userDTO.getPassword(),
                userDTO.getActive(),
                userDTO.getCreatedAt()
        );

        return Boolean.parseBoolean(userDAO.update(userEntity)) ? "User Update Successfully" : "User Update Failed";

    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(userDAO.delete(id)) ? "User Deleted Successfully" : "User Deleted Failed";
    }

    @Override
    public UserDTO search(String id) throws Exception {
        UserEntity userEntity = userDAO.search(id);
        return new UserDTO(
                userEntity.getUserID(),
                userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getActive(),
                userEntity.getCreatedAt()
        );
    }

    @Override
    public ArrayList<UserDTO> getAll() throws Exception {

        ArrayList <UserEntity> userEntities = userDAO.getAll();
        ArrayList <UserDTO> userDTOS = new ArrayList<>();

        for (UserEntity userEntity : userEntities){
            userDTOS.add(new UserDTO(
                    userEntity.getUserID(),
                    userEntity.getUserName(),
                    userEntity.getPassword(),
                    userEntity.getActive(),
                    userEntity.getCreatedAt()
            ));
        }
        return userDTOS;
    }
}
