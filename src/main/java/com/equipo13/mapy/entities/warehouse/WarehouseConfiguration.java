package com.equipo13.mapy.entities.warehouse;
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
public class WarehouseConfiguration {

    @Id
    private int id;

    private double lenghtX;
    private double widhtY;
    private double heightZ;
    private LocalDate fechaIngreso;
    private LocalDate fechaActualizacion;



    @OneToOne
    private Warehouse warehouse;
}
