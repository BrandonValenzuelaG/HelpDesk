package com.valguz.HelpDesk.service;

import com.valguz.HelpDesk.dto.TicketRequestDTO;
import com.valguz.HelpDesk.dto.TicketResponseDTO;
import com.valguz.HelpDesk.dto.TicketUpdateDTO;
import com.valguz.HelpDesk.model.User;

import java.util.List;

public interface TicketService {

    //SHOW TICKET LIST
    List<TicketResponseDTO> getTickets();

    //CREATE TICKET
    TicketResponseDTO newTicket(TicketRequestDTO newTicket);

    //UPDATE TICKET
    TicketResponseDTO updateTicket(Long idTicket, TicketUpdateDTO ticket);

    //SOFT DELETE
    TicketResponseDTO deleteTicket(Long idTicket);

}
