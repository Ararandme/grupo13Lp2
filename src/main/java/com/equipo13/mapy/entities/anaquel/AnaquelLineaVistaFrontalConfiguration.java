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
public class AnaquelLineaVistaFrontalConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String configNombre;

    private double totalHeightY;
    private double totalWidthX;
    private double blockHeightY;
    private int columnAmount;
    private int rowAmount;


    @OneToMany(mappedBy = "FrontalConfiguracion")
    @ToString.Exclude
    private List<Anaquel> anaquel;



}
