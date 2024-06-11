package com.scalar.BookMyShow.models;

import com.scalar.BookMyShow.models.constants.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "User_Table")
@Getter
@Setter
public class BmsUser extends BaseModel {
    private String name;
    private String email;

    @OneToMany
    private List<Ticket> tickets;
}
