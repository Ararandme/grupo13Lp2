package com.equipo13.mapy.entities.anaquel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class AnaquelLineaCeldas {
    @Id
    private int id;
    private double xPosition;
    private double yPosition;


    @ManyToOne
    @ToString.Exclude

    private Anaquel anaquel;


}
