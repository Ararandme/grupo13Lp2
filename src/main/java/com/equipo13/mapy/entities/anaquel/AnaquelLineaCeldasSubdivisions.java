package com.equipo13.mapy.entities.anaquel;

import com.equipo13.mapy.entities.items.Sku;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private Anaquel anaquel;

    @OneToOne
    private Sku sku;

}
