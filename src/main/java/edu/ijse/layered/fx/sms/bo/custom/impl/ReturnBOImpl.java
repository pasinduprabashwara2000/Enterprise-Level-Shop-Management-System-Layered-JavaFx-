package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.ReturnBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.ReturnDAO;
import edu.ijse.layered.fx.sms.dto.ReturnDTO;
import edu.ijse.mvc.fx.shopmanagementsystem.DTO.ReturnEntity;
import java.util.ArrayList;

public class ReturnBOImpl implements ReturnBO {

    ReturnDAO returnDAO = (ReturnDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RETURN);

    @Override
    public String save(ReturnDTO returnDTO) throws Exception {
        ReturnEntity returnEntity = new ReturnEntity(
                returnDTO.getReturnId(),
                returnDTO.getPaymentId(),
                returnDTO.getRefundAmount(),
                returnDTO.getReason(),
                returnDTO.getAction(),
                returnDTO.getStatus(),
                returnDTO.getReturnDate()
        );

        return Boolean.parseBoolean(returnDAO.save(returnEntity)) ? "Return Save Successfully" : "Return Save Failed";
    }

    @Override
    public String update(ReturnDTO returnDTO) throws Exception {

        ReturnEntity returnEntity = new ReturnEntity(
                returnDTO.getReturnId(),
                returnDTO.getPaymentId(),
                returnDTO.getRefundAmount(),
                returnDTO.getReason(),
                returnDTO.getAction(),
                returnDTO.getStatus(),
                returnDTO.getReturnDate()
        );

        return Boolean.parseBoolean(returnDAO.update(returnEntity)) ? "Return Update Successfully" : "Return Update Failed";
    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(returnDAO.delete(id)) ? "Return Delete Successfully" : "Return Delete Failed";
    }

    @Override
    public ReturnDTO search(String id) throws Exception {
        ReturnEntity returnEntity = returnDAO.search(id);
        return new ReturnDTO(
                returnEntity.getReturnId(),
                returnEntity.getPaymentId(),
                returnEntity.getRefundAmount(),
                returnEntity.getReason(),
                returnEntity.getAction(),
                returnEntity.getStatus(),
                returnEntity.getReturnDate()
        );
    }

    @Override
    public ArrayList<ReturnDTO> getAll() throws Exception {
        ArrayList <ReturnEntity> returnEntities = returnDAO.getAll();
        ArrayList <ReturnDTO> returnDTOS = new ArrayList<>();

        for (ReturnEntity returnEntity : returnEntities){
            returnDTOS.add(new ReturnDTO(
                returnEntity.getReturnId(),
                returnEntity.getPaymentId(),
                returnEntity.getRefundAmount(),
                returnEntity.getReason(),
                returnEntity.getAction(),
                returnEntity.getStatus(),
                returnEntity.getReturnDate()
            ));
        }
        return returnDTOS;
    }
}
