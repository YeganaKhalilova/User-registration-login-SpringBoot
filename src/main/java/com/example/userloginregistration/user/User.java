package com.example.userloginregistration.user;


import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private String userRole;

}
