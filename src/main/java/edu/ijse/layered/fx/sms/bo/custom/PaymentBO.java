package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentBO {

    String save(PaymentDTO paymentDTO) throws Exception;
    String update(PaymentDTO paymentDTO) throws Exception;
    String delete(String id) throws Exception;
    PaymentDTO search(String id) throws Exception;
    ArrayList<PaymentDTO> getAll() throws Exception;

}
