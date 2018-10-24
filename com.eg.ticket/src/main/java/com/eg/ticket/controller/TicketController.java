package com.eg.ticket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eg.ticket.model.Ticket;
import com.eg.ticket.ticketrepository.TicketRepository;

@RequestMapping(value = "/")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("")
    public List<Ticket> ticket() {
        return ticketRepository.findAll();
    }

    @PostMapping("/create")
    public Ticket save(@RequestBody Ticket ticket) {
    	return ticketRepository.save(ticket);
    }
    
    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> show(@PathVariable("id") String id) {
    	return ticketRepository.findById(id)
                .map(contact -> ResponseEntity.ok().body(contact))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/tickets/{id}")
    public ResponseEntity<Ticket> update(@PathVariable String id, @RequestBody Ticket ticket) {
        return ticketRepository.findById(id)
        		.map(ticketData -> {
        			ticketData.setName(ticket.getName());
        			ticketData.setDate(ticket.getDate());
        			ticketData.setAssigned_to(ticket.getAssigned_to());
        			ticketData.setSubject(ticket.getSubject());
        			ticketData.setDescription(ticket.getDescription());
        			ticketData.setState(ticket.getState());

        	
        			Ticket updatedTicket = ticketRepository.save(ticketData);
        			return ResponseEntity.ok().body(updatedTicket);
        		}).orElse(ResponseEntity.notFound().build());
    }

   	@DeleteMapping("/tickets/{id}")
   	public ResponseEntity<?> delete(@PathVariable("id") String id){
   		return ticketRepository.findById(id)
   				.map(ticket -> {
   					ticketRepository.deleteById(id);
   					return ResponseEntity.ok().build();
   				}).orElse(ResponseEntity.notFound().build());
   	}
}
