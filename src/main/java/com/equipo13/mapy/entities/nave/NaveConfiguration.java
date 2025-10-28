package com.equipo13.mapy.entities.nave;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class NaveConfiguration {

    @Id
    private int id;

    private double lenghtX;
    private double widthY;
    private double heightZ;
    private double marginSizeLeftX;
    private double marginSizeRightX;
    private double marginSizeTopY;
    private double marginSizeBottonY;
    private double pasilloWidth;
    private double pasilloQuantity;
    private LocalDate fechaIngreso;
    private LocalDate fechaActualzicion;


    @OneToOne
    private Nave nave;
}

