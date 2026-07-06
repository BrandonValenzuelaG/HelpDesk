package com.valguz.HelpDesk.repository;

import com.valguz.HelpDesk.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Long> {
}
