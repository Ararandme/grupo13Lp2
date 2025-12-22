package com.equipo13.mapy.entities.nave;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private int anaquelQuantity;
    private LocalDate fechaIngreso;
    private LocalDate fechaActualzicion;


    @OneToOne
    @JoinColumn(name = "nave_id", nullable = false)
    @ToString.Exclude
    private Nave nave;
}

