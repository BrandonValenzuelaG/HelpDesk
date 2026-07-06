package com.valguz.HelpDesk.controller;

import com.valguz.HelpDesk.dto.TicketRequestDTO;
import com.valguz.HelpDesk.dto.TicketResponseDTO;
import com.valguz.HelpDesk.dto.TicketUpdateDTO;
import com.valguz.HelpDesk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor

public class TicketController {

    private final TicketService ticketServices;

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> getTickets () {

        return ResponseEntity.ok(ticketServices.getTickets());

    }

    @PostMapping
    public ResponseEntity<TicketResponseDTO> newTicket (@RequestBody TicketRequestDTO dto) {

    TicketResponseDTO newTicket = ticketServices.newTicket(dto);

        return ResponseEntity.created(URI.create("/api/ticket/" + newTicket.getIdTicket())).body(newTicket);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> upTicket (@PathVariable Long id, @RequestBody TicketUpdateDTO dto) {

        return ResponseEntity.ok(ticketServices.updateTicket(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket (@PathVariable Long id) {

        ticketServices.deleteTicket(id);

        return ResponseEntity.noContent().build();

    }



}
