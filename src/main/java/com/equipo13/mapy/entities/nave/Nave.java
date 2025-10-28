package com.equipo13.mapy.entities.nave;
import com.equipo13.mapy.entities.anaquel.Anaquel;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Nave {

    @Id
    private int id;

    private String naveAlias;
    private boolean estado;//if is block or not

    @OneToOne
    private NaveConfiguration  naveConfiguration;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany
    private List<Anaquel> anaqueles;
}
