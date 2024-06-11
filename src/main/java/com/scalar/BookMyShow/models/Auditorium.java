package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.AuditoriumFeatures;
import com.scalar.BookMyShow.models.constants.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {
    private String name;
    private int capacity;
    @OneToMany(mappedBy = "auditorium") // only relation between auditorium and show (only in this direction)
    private List<Show>shows;
    @OneToMany
    @JoinColumn(name = "Auditorium_id")
    private List<Seat>seats;

    // for enum it is slightly different
    @ElementCollection // used when we have collection of enums
    @Enumerated(EnumType.STRING) // tell that this particular type is enum and type that comes is of type string
    private List<AuditoriumFeatures>auditoriumFeatures;

    // for single enum
    // @Enumerated(EnumType.STRING)
    // private AuditoriumFeatures auditoriumFeature;
}
