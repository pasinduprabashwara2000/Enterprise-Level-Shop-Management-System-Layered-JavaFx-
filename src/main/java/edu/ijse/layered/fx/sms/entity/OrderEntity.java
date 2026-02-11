package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEntity {

    private int orderId;
    private String customerId;
    private Date orderDate;
    List<OrderProductEntity> orderItems;

    public OrderEntity(String customerId, Date orderDate, List<OrderProductEntity> orderItems){
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }

}


