package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Auditorium auditorium;

    @ManyToOne
    @JoinColumn(name = "Movie_id")
    private Movie movie;
    /* show movie
        1  -> 1
        m  -> 1
     */

    @OneToMany(mappedBy = "Show ")
    private List<ShowSeat>showSeats;
}
