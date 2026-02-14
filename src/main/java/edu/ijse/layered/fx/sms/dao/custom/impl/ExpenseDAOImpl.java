package edu.ijse.layered.fx.sms.dao.custom.impl;

import edu.ijse.layered.fx.sms.dao.custom.ExpenseDAO;
import edu.ijse.layered.fx.sms.entity.ExpenseEntity;
import edu.ijse.layered.fx.sms.util.CrudUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        return CrudUtil.execute("DELETE FROM expense WHERE id = ?", id);
    }

    @Override
    public ExpenseEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM expense WHERE id = ?", id);

        if (rst.next()){
            return new ExpenseEntity(
                    rst.getString("id"),
                    rst.getString("title"),
                    rst.getString("category_type"),
                    rst.getDouble("amount"),
                    rst.getString("payment_method"),
                    rst.getDate("date").toLocalDate()
            );
        }
        return null;
    }

    @Override
    public ArrayList<ExpenseEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM expense");
        ArrayList <ExpenseEntity> expenseEntities = new ArrayList<>();

        while (rst.next()){
            expenseEntities.add(new ExpenseEntity(
                    rst.getString("id"),
                    rst.getString("title"),
                    rst.getString("category_type"),
                    rst.getDouble("amount"),
                    rst.getString("payment_method"),
                    rst.getDate("date").toLocalDate()
            ));
        }
        return expenseEntities;
    }
}
