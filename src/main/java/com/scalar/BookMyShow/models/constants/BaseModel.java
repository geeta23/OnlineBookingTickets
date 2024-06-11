package com.scalar.BookMyShow.models.constants;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass // tell that these class attributes should be added as columns in all the entities
@Getter
@Setter
public abstract class BaseModel {
    @Id // tell JPA that ID is primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // tell to automatically generate the value
    @Column(name = "ID") // we can specify the name of the column in table
    private int id;
}
