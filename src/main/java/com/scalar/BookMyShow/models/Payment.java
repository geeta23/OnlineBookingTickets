package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import com.scalar.BookMyShow.models.constants.PaymentMethod;
import com.scalar.BookMyShow.models.constants.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Payment extends BaseModel {
    private LocalDateTime paymentTime;
    private double amount;
    private String referenceID;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "Ticket_id")
    private Ticket ticket;

    @OneToMany
    private List<Transaction>transactions;
}

/*
*  Ticket Payment
*    1      m(failed payments)
*    1      1
* */
