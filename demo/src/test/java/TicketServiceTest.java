package com.example.service;

import com.example.model.Ticket;
import com.example.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    public TicketServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTicket() {
        Ticket ticket = new Ticket();
        ticket.setTitle("Network Issue");
        ticket.setPriority("High");

        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        Ticket createdTicket = ticketService.createTicket(ticket);

        assertNotNull(createdTicket);
        assertEquals("Network Issue", createdTicket.getTitle());
        assertEquals("High", createdTicket.getPriority());
    }
}
