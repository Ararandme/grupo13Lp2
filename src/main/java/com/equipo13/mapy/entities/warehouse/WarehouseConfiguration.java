package com.equipo13.mapy.entities.warehouse;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double lenghtX;
    private double widhtY;
    private double heightZ;
    private LocalDate fechaIngreso;
    private LocalDate fechaActualizacion;



    @OneToOne
    @JoinColumn(name = "warehouse_id", unique = true, nullable = false)
    @ToString.Exclude
    private Warehouse warehouse;
}
