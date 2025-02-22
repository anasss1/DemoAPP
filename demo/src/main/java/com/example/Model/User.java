package com.example.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private String role; // 'EMPLOYEE', 'IT_SUPPORT'

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;
}
