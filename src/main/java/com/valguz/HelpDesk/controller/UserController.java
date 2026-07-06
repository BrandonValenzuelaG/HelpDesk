package com.valguz.HelpDesk.controller;


import com.valguz.HelpDesk.dto.UserRequestDTO;
import com.valguz.HelpDesk.dto.UserResponseDTO;
import com.valguz.HelpDesk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers(){

        return ResponseEntity.ok(userService.getUsers());

    }



    @PostMapping
    public ResponseEntity<UserResponseDTO> newUser (@RequestBody UserRequestDTO dto) {

        UserResponseDTO newUser = userService.newUser(dto);

        return ResponseEntity.created(URI.create("/api/user/" + newUser.getId())).body(newUser);

    }


}
