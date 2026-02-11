package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderProductEntity {

    private int orderId;
    private String productId;
    private int qty;
    private double price;

    public OrderProductEntity(String productId, double price, int qty) {
        this.productId = productId;
        this.price = price;
        this.qty = qty;
    }

}
