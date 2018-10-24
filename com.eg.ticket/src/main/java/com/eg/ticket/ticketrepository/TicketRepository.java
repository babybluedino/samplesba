package com.eg.ticket.ticketrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eg.ticket.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String>{

}