package com.equipo13.mapy.entities.warehouse;
import com.equipo13.mapy.entities.nave.Nave;
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
public class Warehouse {

    @Id
    private int id;

    private String warehouseAlias;
    private boolean estado;//if is block or not


    @OneToOne
    private WarehouseConfiguration warehouses;

    @OneToMany
    private List<Nave> naves;
}
