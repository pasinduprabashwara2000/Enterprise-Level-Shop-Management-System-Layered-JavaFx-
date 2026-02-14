package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.PaymentDAO;
import edu.ijse.layered.fx.sms.entity.PaymentEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        return CrudUtil.execute("DELETE FROM Payment WHERE payment_id = ?", id);
    }

    @Override
    public PaymentEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Payment WHERE payment_id = ?", id);
        return new PaymentEntity(
                rst.getString("payment_id"),
                rst.getString("customer_id"),
                rst.getString("method"),
                rst.getDouble("amount"),
                rst.getString("reference"),
                rst.getDate("received_at").toLocalDate()
        );
    }

    @Override
    public ArrayList<PaymentEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Payment");

        ArrayList<PaymentEntity> paymentEntities = new ArrayList<>();

        while (rst.next()){
            paymentEntities.add(new PaymentEntity(
                    rst.getString("payment_id"),
                    rst.getString("customer_id"),
                    rst.getString("method"),
                    rst.getDouble("amount"),
                    rst.getString("reference"),
                    rst.getDate("received_at").toLocalDate()
            ));
        }
        return paymentEntities;
    }
}
