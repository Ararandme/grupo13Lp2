package com.equipo13.mapy.entities.items;

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
public class SkuDataLogistica {
    @Id
    private int id;
    private double ancho;
    private double largo;
    private double altura;
    private double peso;
    private String tipo;
    private LocalDate fechaIngreso;
    private LocalDate fechaActualizacion;

    @OneToOne
    private Sku sku;


}
