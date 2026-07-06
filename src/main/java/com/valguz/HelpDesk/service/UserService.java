package com.valguz.HelpDesk.service;

import com.valguz.HelpDesk.dto.UserRequestDTO;
import com.valguz.HelpDesk.dto.UserResponseDTO;
import com.valguz.HelpDesk.model.User;

import java.util.List;

public interface UserService {

    User userExists(Long id);

    UserResponseDTO newUser (UserRequestDTO dto);

    List<UserResponseDTO> getUsers();







}
