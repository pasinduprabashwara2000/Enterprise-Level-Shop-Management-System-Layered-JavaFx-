package edu.ijse.layered.fx.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {

    private String categoryID;
    private String name;
    private String description;

}