package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.PaymentDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.PaymentEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public String save(PaymentEntity paymentEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO Payment (customer_id, method, amount, reference, received_at) VALUES (?, ?, ?, ?, ?)",
                paymentEntity.getCustomerID(),
                paymentEntity.getMethod(),
                paymentEntity.getAmount(),
                paymentEntity.getReference(),
                paymentEntity.getReceivedAt());
    }

    @Override
    public String update(PaymentEntity paymentEntity) throws Exception {
        return CrudUtil.execute("UPDATE Payment SET customer_id = ?, method = ?, amount = ?, reference = ?, received_at = ? WHERE payment_id = ?",
                paymentEntity.getCustomerID(),
                paymentEntity.getMethod(),
                paymentEntity.getAmount(),
                paymentEntity.getReference(),
                paymentEntity.getReceivedAt(),
                paymentEntity.getPaymentID());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Payment WHERE payment_id = ?",
                id);
    }

    @Override
    public PaymentEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM Payment WHERE payment_id = ?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM Payment");
    }
}
