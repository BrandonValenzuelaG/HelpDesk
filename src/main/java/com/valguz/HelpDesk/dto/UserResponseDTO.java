package com.valguz.HelpDesk.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valguz.HelpDesk.model.enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserResponseDTO {

    @JsonIgnore
    private Long id;

    private String name;
    private String department;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
