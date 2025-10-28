package com.equipo13.mapy.entities.items;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class SkuKardex {
    @Id
    private int id;

    private int cantidadIngreso;
    private LocalDate fechaIngreso;
    private LocalDate horaIngreso;
    private String cantidadSalida;
    private LocalDate fechaSalida;
    private String horaSalida;
    private String enUsoPorUsuario;

    @ManyToOne
    private Sku sku;


}
