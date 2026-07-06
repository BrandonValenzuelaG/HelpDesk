package com.valguz.HelpDesk.service;


import com.valguz.HelpDesk.dto.TicketRequestDTO;
import com.valguz.HelpDesk.dto.TicketResponseDTO;
import com.valguz.HelpDesk.dto.TicketUpdateDTO;
import com.valguz.HelpDesk.exception.NotFoundException;
import com.valguz.HelpDesk.mapper.Mapper;
import com.valguz.HelpDesk.model.Ticket;
import com.valguz.HelpDesk.model.User;
import com.valguz.HelpDesk.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TicketServiceImpl implements TicketService {


    private final TicketRepository rep;

    private final UserService findUser;

    @Override
    public List<TicketResponseDTO> getTickets() {

        return rep.findAll().stream().map(Mapper::tToDTO).toList();
    }

    @Override
    public TicketResponseDTO newTicket(TicketRequestDTO ticket) {

        User user = findUser.userExists(ticket.getIdUser());

       Ticket newTicket = Mapper.uToEntity(ticket, user);
       newTicket.setStatus("OPEN");
       Ticket ticketSaved = rep.save(newTicket);

       return Mapper.tToDTO(ticketSaved);

    }

    @Override
    public TicketResponseDTO updateTicket(Long idTicket, TicketUpdateDTO ticket) {

        Ticket upTicket = rep.findById(idTicket)
                .orElseThrow(() -> new NotFoundException("Ticket no encontrado..."));

        upTicket.setStatus(ticket.getStatus());
        upTicket.setComment(ticket.getComment());

        Ticket upSaved = rep.save(upTicket);

        return Mapper.tToDTO(upSaved);

    }

    @Override
    public TicketResponseDTO deleteTicket(Long idTicket) {
        Ticket delTicket = rep.findById(idTicket)
                .orElseThrow(() -> new NotFoundException("Ticket no encontrado..."));

        delTicket.setStatus("DELETED");

        Ticket delConfirm = rep.save(delTicket);

        return Mapper.tToDTO(delConfirm);
    }
}
