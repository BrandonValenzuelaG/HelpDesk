package com.valguz.HelpDesk.dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TicketRequestDTO {
    private Long idUser;
    private String subject;
    private String message;
    private String urgency;

}
