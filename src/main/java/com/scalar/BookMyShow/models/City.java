package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity // tell JPA to create table for this class
@Getter
@Setter
public class City extends BaseModel {

    @Column(name = "CityName")
    private String name;

    @OneToMany // tell JPA that the relation between city and theater
    @JoinColumn(name = "City_id")
    private List<Theater> theatres;
}
