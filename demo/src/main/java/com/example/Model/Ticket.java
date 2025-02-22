package com.example.Model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String priority; // Low, Medium, High
    private String category; // Network, Hardware, Software, Other
    private String status = "New"; // Default status is "New"
    private LocalDateTime creationDate = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
