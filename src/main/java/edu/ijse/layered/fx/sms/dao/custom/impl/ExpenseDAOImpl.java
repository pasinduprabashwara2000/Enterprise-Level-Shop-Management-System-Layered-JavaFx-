package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.ExpenseDAO;
import edu.ijse.layered.fx.sms.dto.CategoryDTO;
import edu.ijse.layered.fx.sms.entity.ExpenseEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;

public class ExpenseDAOImpl implements ExpenseDAO {

    @Override
    public String save(ExpenseEntity expenseEntity) throws Exception {
        return CrudUtil.execute("INSERT INTO expense (title,category_type,amount,payment_method,date) VALUES (?,?,?,?,?)",
                expenseEntity.getTitle(),
                expenseEntity.getCategoryType(),
                expenseEntity.getAmount(),
                expenseEntity.getPaymentMethod(),
                expenseEntity.getDate());
    }

    @Override
    public String update(ExpenseEntity expenseEntity) throws Exception {
        return CrudUtil.execute("UPDATE expense SET title = ?, category_type = ?, amount = ?, payment_method = ?, date = ? WHERE id = ?",
                expenseEntity.getTitle(),
                expenseEntity.getCategoryType(),
                expenseEntity.getAmount(),
                expenseEntity.getPaymentMethod(),
                expenseEntity.getDate(),
                expenseEntity.getId());
    }

    @Override
    public String delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM expense WHERE id = ?",
                id);
    }

    @Override
    public ExpenseEntity search(String id) throws Exception {
        return CrudUtil.execute("SELECT * FROM expense WHERE id = ?",
                id);
    }

    @Override
    public CategoryDTO getAll() throws Exception {
        return CrudUtil.execute("SELECT * FROM expense");
    }
}
