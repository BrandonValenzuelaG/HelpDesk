package com.valguz.HelpDesk.service;


import com.valguz.HelpDesk.dto.UserRequestDTO;
import com.valguz.HelpDesk.dto.UserResponseDTO;
import com.valguz.HelpDesk.exception.NotFoundException;
import com.valguz.HelpDesk.mapper.Mapper;
import com.valguz.HelpDesk.model.User;
import com.valguz.HelpDesk.model.enums.UserStatus;
import com.valguz.HelpDesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository repo;


    @Override
    public User userExists(Long id) {

        User user = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Empleado no encontrado..."));

        return user;

    }

    @Override
    public UserResponseDTO newUser(UserRequestDTO dto) {

        User newUser = Mapper.uToEntity(dto);

        newUser.setStatus(UserStatus.ACTIVE);
        newUser.setRole(dto.getRole());

        User userSaved = repo.save(newUser);

        return Mapper.uToDTO(userSaved);

    }

    @Override
    public List<UserResponseDTO> getUsers() {

        return repo.findAll().stream().map(Mapper::uToDTO).toList();

    }


}
