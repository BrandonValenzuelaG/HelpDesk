package com.valguz.HelpDesk.repository;

import com.valguz.HelpDesk.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository <Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.status != 'DELETED'")
    List<Ticket> findAllActive();


}
