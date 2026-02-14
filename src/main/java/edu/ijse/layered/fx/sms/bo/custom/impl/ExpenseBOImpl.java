package edu.ijse.layered.fx.sms.bo.custom.impl;

import edu.ijse.layered.fx.sms.bo.custom.ExpenseBO;
import edu.ijse.layered.fx.sms.dao.DAOFactory;
import edu.ijse.layered.fx.sms.dao.custom.ExpenseDAO;
import edu.ijse.layered.fx.sms.dto.ExpenseDTO;
import edu.ijse.layered.fx.sms.entity.ExpenseEntity;
import java.util.ArrayList;

public class ExpenseBOImpl implements ExpenseBO {

    ExpenseDAO expenseDAO = (ExpenseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EXPENSE);

    @Override
    public String save(ExpenseDTO expenseDTO) throws Exception {
        ExpenseEntity expenseEntity = new ExpenseEntity(
                expenseDTO.getId(),
                expenseDTO.getTitle(),
                expenseDTO.getCategoryType(),
                expenseDTO.getAmount(),
                expenseDTO.getPaymentMethod(),
                expenseDTO.getDate()
        );
        return Boolean.parseBoolean(expenseDAO.save(expenseEntity)) ? "Expense Save Successfully" : "Expense Save Failed";
    }

    @Override
    public String update(ExpenseDTO expenseDTO) throws Exception {
        ExpenseEntity expenseEntity = new ExpenseEntity(
                expenseDTO.getId(),
                expenseDTO.getTitle(),
                expenseDTO.getCategoryType(),
                expenseDTO.getAmount(),
                expenseDTO.getPaymentMethod(),
                expenseDTO.getDate()
        );
        return Boolean.parseBoolean(expenseDAO.update(expenseEntity)) ? "Expense Update Successfully" : "Expense Update Failed";
    }

    @Override
    public String delete(String id) throws Exception {
        return Boolean.parseBoolean(expenseDAO.delete(id)) ? "Expense Delete Successfully" : "Expense Delete Failed";
    }

    @Override
    public ExpenseDTO search(String id) throws Exception {
        ExpenseEntity expenseEntity = expenseDAO.search(id);
        return new ExpenseDTO(
                expenseEntity.getId(),
                expenseEntity.getTitle(),
                expenseEntity.getCategoryType(),
                expenseEntity.getAmount(),
                expenseEntity.getPaymentMethod(),
                expenseEntity.getDate()
        );
    }

    @Override
    public ArrayList<ExpenseDTO> getAll() throws Exception {
        ArrayList<ExpenseEntity> expenseEntities = expenseDAO.getAll();
        ArrayList<ExpenseDTO> expenseDTOS = new ArrayList<>();

        for (ExpenseEntity expenseEntity : expenseEntities){
            expenseDTOS.add(new ExpenseDTO(
                    expenseEntity.getId(),
                    expenseEntity.getTitle(),
                    expenseEntity.getCategoryType(),
                    expenseEntity.getAmount(),
                    expenseEntity.getPaymentMethod(),
                    expenseEntity.getDate()
            ));
        }
        return expenseDTOS;
    }
}
