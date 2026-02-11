package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerEntity {

    private String customerId;
    private String name;
    private int phone;
    private String email;
    private String loyaltyCode;

}
