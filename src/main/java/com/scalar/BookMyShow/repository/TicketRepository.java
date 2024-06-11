package com.scalar.BookMyShow.repository;

import com.scalar.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}

// this will create repository with key the integer id and value as ticket
// all CRUD operations can be done on the dataTable


