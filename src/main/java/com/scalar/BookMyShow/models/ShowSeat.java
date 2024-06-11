package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import com.scalar.BookMyShow.models.constants.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel {
    private int price;
    @ManyToOne
    private Show show;

    @ManyToOne
    @JoinColumn(name = "ShowSeat_id")
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}

/*
    showSeat show
       1      1
       m      1
 */

/*
    showSeat seat
       1      1
       m      1(one physical seat can be part of multiple shows)
 */
