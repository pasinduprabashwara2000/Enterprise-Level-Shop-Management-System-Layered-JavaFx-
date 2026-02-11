package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseOrderEntity {

    private String poId;
    private String supplierId;
    private Double totalCost;
    private String status;
    private LocalDate createdAt;
    private LocalDate expectedDate;

}
