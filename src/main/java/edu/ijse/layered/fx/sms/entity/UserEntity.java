package edu.ijse.layered.fx.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
    
    private String userID;
    private String userName;
    private String password;
    private String active;
    private LocalDate createdAt;

}
