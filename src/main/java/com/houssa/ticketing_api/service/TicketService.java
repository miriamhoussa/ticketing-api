package com.houssa.ticketing_api.service;

import com.houssa.ticketing_api.entity.Ticket;
import com.houssa.ticketing_api.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class TicketService {
    
    @Autowired 
    private TicketRepository ticketRepository;

    //1. Crear un ticket nuevo
    public Ticket createTicket(Ticket ticket) {
        ticket.setStatus("PENDIENTE"); //Nace con estado pendiente
        ticket.setCreatedAt(LocalDateTime.now()); //Registra la fecha de creación del ticket

        return ticketRepository.save(ticket); //Guarda el ticket en la base de datos

    }

    //2. Ver todos los tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    //3. El administrador cambia el estado
    public Ticket updateStatus(Long ticketId, String newStatus) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado con id: " + ticketId));

        //Si existe, le cambia el estado y se guarda
        ticket.setStatus(newStatus);
        return ticketRepository.save(ticket);
    }

}
