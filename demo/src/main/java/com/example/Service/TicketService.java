package com.example.Service;

import com.yourcompany.model.Ticket;
import com.yourcompany.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsByUser(Long userId) {
        return ticketRepository.findByUserId(userId);
    }

    public Ticket updateTicketStatus(Long ticketId, String status) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
}