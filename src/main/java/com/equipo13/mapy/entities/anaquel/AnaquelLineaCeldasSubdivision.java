package com.equipo13.mapy.entities.anaquel;

import com.equipo13.mapy.entities.items.Sku;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class AnaquelLineaCeldasSubdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double divisionNumber;

    @ManyToOne
    @JoinColumn(name = "anaquel_linea_celda_id")
    @ToString.Exclude
    private AnaquelLineaCelda anaquelLineaCelda;

    @OneToOne
    @JoinColumn(name = "anaquel_subdivion_id")
    @ToString.Exclude
    private Sku sku;

}
