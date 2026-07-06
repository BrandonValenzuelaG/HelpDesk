package com.valguz.HelpDesk.mapper;

import com.valguz.HelpDesk.dto.TicketRequestDTO;
import com.valguz.HelpDesk.dto.TicketResponseDTO;
import com.valguz.HelpDesk.dto.UserRequestDTO;
import com.valguz.HelpDesk.dto.UserResponseDTO;
import com.valguz.HelpDesk.model.Ticket;
import com.valguz.HelpDesk.model.User;

import java.time.LocalDateTime;

public class Mapper {

    //Ticket: Mapeo DTO -> Entity
    public static Ticket uToEntity(TicketRequestDTO dto, User user) {

        return Ticket.builder()
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .urgency(dto.getUrgency())
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();

    }

    //Ticket: Mapeo Entity -> DTO
    public static TicketResponseDTO tToDTO(Ticket ticket) {

        return TicketResponseDTO.builder()
                .idTicket(ticket.getId())
                .userName(ticket.getUser().getName())
                .subject(ticket.getSubject())
                .message(ticket.getMessage())
                .urgency(ticket.getUrgency())
                .createdAt(ticket.getCreatedAt())
                .status(ticket.getStatus())
                .build();

    }

    //User: Mapeo DTO -> Entity
    public static User uToEntity(UserRequestDTO dto) {

        return User.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .role(dto.getRole())
                .build();

    }

    //User. Mapeo Entity -> DTO
    public static UserResponseDTO uToDTO(User user) {

        return UserResponseDTO.builder()
                .name(user.getName())
                .department(user.getDepartment())
                .role(user.getRole())
                .build();

    }


}
