package edu.ijse.layered.fx.sms.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderProductTM {

    private String productId;
    private String productName;
    private int orderQty;
    private double unitPrice;
    private double productTotal;

}