package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.ReturnDAO;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import edu.ijse.mvc.fx.shopmanagementsystem.DTO.ReturnEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReturnDAOImpl implements ReturnDAO {

    @Override
    public String save(ReturnEntity returnEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO Returns (paymentId, action, reason, refundAmount, returnDate, status) VALUES (?, ?, ?, ?, ?, ?)",
                returnEntity.getPaymentId(),
                returnEntity.getAction(),
                returnEntity.getReason(),
                returnEntity.getRefundAmount(),
                returnEntity.getReturnDate(),
                returnEntity.getStatus());
    }

    @Override
    public String update(ReturnEntity returnEntity) throws Exception {
        return CrudUtil.execute("UPDATE Returns SET paymentId = ?, action = ?, reason = ?, refundAmount = ?, returnDate = ?, status = ? WHERE returnId = ?",
                returnEntity.getPaymentId(),
                returnEntity.getAction(),
                returnEntity.getReason(),
                returnEntity.getRefundAmount(),
                returnEntity.getReturnDate(),
                returnEntity.getStatus(),
                returnEntity.getReturnId());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Returns WHERE returnId = ?", id);
    }

    @Override
    public ReturnEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Returns WHERE returnId = ?", id);
        return new ReturnEntity(
                rst.getString("returnId"),
                rst.getString("paymentId"),
                rst.getDouble("refundAmount"),
                rst.getString("reason"),
                rst.getString("action"),
                rst.getString("status"),
                rst.getDate("returnDate").toLocalDate()
        );
    }

    @Override
    public ArrayList<ReturnEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Returns");
        ArrayList <ReturnEntity> returnEntities = new ArrayList<>();

        while (rst.next()){
            returnEntities.add(new ReturnEntity(
                    rst.getString("returnId"),
                    rst.getString("paymentId"),
                    rst.getDouble("refundAmount"),
                    rst.getString("reason"),
                    rst.getString("action"),
                    rst.getString("status"),
                    rst.getDate("returnDate").toLocalDate()
            ));
        }
        return returnEntities;
    }
}
