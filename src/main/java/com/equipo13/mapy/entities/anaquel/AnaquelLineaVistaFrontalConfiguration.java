package com.equipo13.mapy.entities.anaquel;
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
public class AnaquelLineaVistaFrontalConfiguration {
    @Id
    private int id;

    private double totalHeightY;
    private double totalWidthX;
    private double blockHeightY;

    private LocalDate fechaIngreso;
    private LocalDate fechaActualizacion;

    @OneToOne
    private Anaquel anaquel;
}
