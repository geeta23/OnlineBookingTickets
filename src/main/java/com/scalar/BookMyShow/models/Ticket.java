package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import com.scalar.BookMyShow.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    private LocalDateTime timeOfBooking;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "Ticket_id")
    private Show show;

    @ManyToMany
    private List<ShowSeat>showSeats;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}

/*
    Ticket Show
      1     1
      m     1

      Ticket ShowSeat
      1        m
      m        1(supporting cancelled seats)
 */
