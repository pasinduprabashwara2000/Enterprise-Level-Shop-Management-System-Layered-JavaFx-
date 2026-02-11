package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierEntity {
    
    private String supplierID;
    private String name;
    private String contactPerson;
    private int phone;
    private String email;
    private String address;

}
