package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.RoleDTO;

import java.util.ArrayList;

public interface RoleBO {

    String save(RoleDTO roleDTO) throws Exception;
    String update(RoleDTO roleDTO) throws Exception;
    String delete(String id) throws Exception;
    RoleDTO search(String id) throws Exception;
    ArrayList<RoleDTO> getAll() throws Exception;

}
