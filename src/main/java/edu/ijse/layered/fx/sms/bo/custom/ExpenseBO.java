package edu.ijse.layered.fx.sms.bo.custom;

import edu.ijse.layered.fx.sms.dto.ExpenseDTO;

import java.util.ArrayList;

public interface ExpenseBO {

    String save(ExpenseDTO expenseDTO) throws Exception;
    String update(ExpenseDTO expenseDTO) throws Exception;
    String delete(String id) throws Exception;
    ExpenseDTO search(String id) throws Exception;
    ArrayList<ExpenseDTO> getAll() throws Exception;

}
