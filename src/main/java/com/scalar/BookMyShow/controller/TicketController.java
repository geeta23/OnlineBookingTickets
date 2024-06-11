package com.scalar.BookMyShow.controller;

import com.scalar.BookMyShow.dtos.BookTicketRequestDto;
import com.scalar.BookMyShow.dtos.TicketResponseDTO;
import com.scalar.BookMyShow.exception.ShowSeatNotAvailableException;
import com.scalar.BookMyShow.models.Ticket;
import com.scalar.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    // for post call we just write @RequestBody and in postman send the body in raw JSON format
    // for get call add a @PathVariable and hit it by postman
    // the request body converts the json object to DTO
    @PostMapping("/ticket")
    public ResponseEntity createTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) throws ShowSeatNotAvailableException {
        //Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getShowSeatIds(), bookTicketRequestDto.getUserId());
        // we have to get the ticket response data from above result, but for time being we are creating it
        TicketResponseDTO ticket = new TicketResponseDTO();
        ticket.setAuditoriumName("AUDI1");
        ticket.setMovieName("Chinna");
        ticket.setSeatNumber(List.of("A1, A2"));
        ticket.setTimeOfShow(LocalDateTime.now());
        ticket.setTotalAmount(300);
        return ResponseEntity.ok(ticket);
    }
}
