package com.equipo13.mapy.entities.anaquel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class AnaquelLineaVistaSuperiorConfiguracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String configNombre;

    private double columnSeparationWidth;
    private double middlePaddingSize;
    private double anaquelBlockWidhtX;
    private double anaquelTotalWidthX;
    private double anaquelBlockHeightY;
    private int    anaquelBlockDepth;



    @OneToMany(mappedBy = "SuperiorConfiguracion")
    @ToString.Exclude
    private List<Anaquel> anaquel;
}
