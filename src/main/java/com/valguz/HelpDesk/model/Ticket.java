package com.valguz.HelpDesk.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String message;
    private String urgency;
    private LocalDateTime createdAt;
    private String status;
    private String comment;

    @ManyToOne
    private User user;

}
