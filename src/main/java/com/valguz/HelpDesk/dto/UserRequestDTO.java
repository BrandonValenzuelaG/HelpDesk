package com.valguz.HelpDesk.dto;

import com.valguz.HelpDesk.model.enums.RoleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDTO {

    private String name;
    private String department;
    private RoleType role;
}
