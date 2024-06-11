package com.scalar.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TicketResponseDTO {
    private double TotalAmount;
    private LocalDateTime timeOfShow;
    private List<String> seatNumber;
    private String movieName;
    private String auditoriumName;
}
