package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseEntity {

    private String id;
    private String title;
    private String categoryType;
    private double amount;
    private String paymentMethod;
    private LocalDate date;

}
