package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.ReturnDTO;

import java.util.ArrayList;

public interface ReturnBO {

    String save(ReturnDTO returnDTO) throws Exception;
    String update(ReturnDTO returnDTO) throws Exception;
    String delete(String id) throws Exception;
    ReturnDTO search(String id) throws Exception;
    ArrayList<ReturnDTO> getAll() throws Exception;

}
