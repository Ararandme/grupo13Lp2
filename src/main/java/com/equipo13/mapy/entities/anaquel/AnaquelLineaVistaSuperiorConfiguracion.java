package com.equipo13.mapy.entities.anaquel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class AnaquelLineaVistaSuperiorConfiguracion {

    @Id
    private int id;

    private double columnSeparationWidth;
    private double middlePaddingSize;
    private double anaquelBlockWidhtX;
    private double anaquelTotalWidthX;
    private double anaquelBlockHeightY;
    private double anaquelBlockAmountX;
    private double anaquelBlockAmountY;
    private LocalDate fechaIngreso;
    private LocalDate fechaActualizacion;


    @OneToOne
    @JoinColumn(name = "anaquel_supconfig_id", nullable = false, unique = true)
    @ToString.Exclude
    private Anaquel anaquel;
}
