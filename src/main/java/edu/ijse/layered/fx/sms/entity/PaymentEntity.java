package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentEntity {

    private String paymentID;
    private String customerID;
    private String method;
    private double amount;
    private String reference;
    private LocalDate receivedAt;

}
