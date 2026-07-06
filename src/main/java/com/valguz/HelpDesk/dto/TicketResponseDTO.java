package com.valguz.HelpDesk.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TicketResponseDTO {

    private Long idTicket;
    private String userName;
    private String subject;
    private String message;
    private String urgency;
    private LocalDateTime createdAt;
    private String status;

}
