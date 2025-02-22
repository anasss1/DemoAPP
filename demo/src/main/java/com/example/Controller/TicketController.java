package com.exmaple.controller;

import com.example.model.Ticket;
import com.example.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsByUser(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @PutMapping("/{ticketId}/status")
    public Ticket updateTicketStatus(@PathVariable Long ticketId, @RequestParam String status) {
        return ticketService.updateTicketStatus(ticketId, status);
    }
}


