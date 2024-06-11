package com.scalar.BookMyShow.service;

import com.scalar.BookMyShow.exception.ShowSeatNotAvailableException;
import com.scalar.BookMyShow.models.BmsUser;
import com.scalar.BookMyShow.models.ShowSeat;
import com.scalar.BookMyShow.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(List<Integer> showSeatsIds, Integer bmsUser_ID) throws ShowSeatNotAvailableException;
}
