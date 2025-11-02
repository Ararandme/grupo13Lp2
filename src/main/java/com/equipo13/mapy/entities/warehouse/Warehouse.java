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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 20, unique = true)
    private String warehouseAlias;
    private boolean estado;//if is block or not


    @OneToOne(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @ToString.Exclude
    private WarehouseConfiguration warehousesConfiguration;

    @OneToMany
    @ToString.Exclude
    private List<Nave> naves;
}
