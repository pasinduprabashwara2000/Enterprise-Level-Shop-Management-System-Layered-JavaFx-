package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.PaymentBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.PaymentDAO;
import edu.ijse.layered.fx.sms.dto.PaymentDTO;
import edu.ijse.layered.fx.sms.entity.PaymentEntity;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);

    @Override
    public String save(PaymentDTO paymentDTO) throws Exception {

        PaymentEntity paymentEntity = new PaymentEntity(
                paymentDTO.getPaymentID(),
                paymentDTO.getCustomerID(),
                paymentDTO.getMethod(),
                paymentDTO.getAmount(),
                paymentDTO.getReference(),
                paymentDTO.getReceivedAt()
        );

        return Boolean.parseBoolean(paymentDAO.save(paymentEntity)) ? "Payment Added Successfully" : "Payment Added Failed";
    }

    @Override
    public String update(PaymentDTO paymentDTO) throws Exception {

        PaymentEntity paymentEntity = new PaymentEntity(
             paymentDTO.getPaymentID(),
             paymentDTO.getCustomerID(),
             paymentDTO.getMethod(),
             paymentDTO.getAmount(),
             paymentDTO.getReference(),
             paymentDTO.getReceivedAt()
        );

        return Boolean.parseBoolean(paymentDAO.update(paymentEntity)) ? "Payment Update Successfully" : "Payment Update Failed";
    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(paymentDAO.delete(id)) ? "Payment Delete Successfully" : "Payment Delete Failed";
    }

    @Override
    public PaymentDTO search(String id) throws Exception {
        PaymentEntity paymentEntity = paymentDAO.search(id);
        return new PaymentDTO(
                paymentEntity.getPaymentID(),
                paymentEntity.getCustomerID(),
                paymentEntity.getMethod(),
                paymentEntity.getAmount(),
                paymentEntity.getReference(),
                paymentEntity.getReceivedAt()
        );
    }

    @Override
    public ArrayList<PaymentDTO> getAll() throws Exception {
        ArrayList <PaymentEntity> paymentEntities = paymentDAO.getAll();
        ArrayList <PaymentDTO> paymentDTOS = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentEntities){
            paymentDTOS.add(new PaymentDTO (
                    paymentEntity.getPaymentID(),
                    paymentEntity.getCustomerID(),
                    paymentEntity.getMethod(),
                    paymentEntity.getAmount(),
                    paymentEntity.getReference(),
                    paymentEntity.getReceivedAt()
            ));
        }
        return paymentDTOS;
    }
}
