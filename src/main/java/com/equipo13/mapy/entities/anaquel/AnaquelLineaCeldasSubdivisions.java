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
public class AnaquelLineaCeldasSubdivisions {

    @Id
    private int id;

    private double divisionNumber;

    @ManyToOne
    @ToString.Exclude
    private Anaquel anaquel;

    @OneToOne
    @JoinColumn(name = "anaquel_subdivion_id", unique = true, nullable = false)
    @ToString.Exclude
    private Sku sku;

}
