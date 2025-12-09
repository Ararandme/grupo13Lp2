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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naveAlias;

    private boolean estado;//if is block or not

    @OneToOne(mappedBy = "nave", cascade = CascadeType.ALL)
    @ToString.Exclude
    private NaveConfiguration  naveConfiguration;

    @ManyToOne(optional = false)
    @ToString.Exclude
    private Warehouse warehouse;

    @OneToMany
    @ToString.Exclude
    private List<Anaquel> anaqueles;
}
