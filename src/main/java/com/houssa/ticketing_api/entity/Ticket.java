package com.houssa.ticketing_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    private String description;
    
    private String status; // Ejemplos: "PENDIENTE", "EN_PROCESO", "RESUELTO"
    
    private LocalDateTime createdAt;
}
