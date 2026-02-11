package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.ReturnDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import edu.ijse.mvc.fx.shopmanagementsystem.DTO.ReturnEntity;

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
        return CrudUtil.execute("DELETE FROM Returns WHERE returnId = ?",
                id);
    }

    @Override
    public ReturnEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM Returns WHERE returnId = ?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM Returns");
    }
}
