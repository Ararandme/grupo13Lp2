package com.equipo13.mapy.entities.anaquel;
import com.equipo13.mapy.entities.nave.Nave;
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
public class Anaquel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int anaquelIndex;
    private boolean estado;//if is block or not



    @ManyToOne
    @ToString.Exclude
    private Nave nave;

    @OneToOne(mappedBy = "anaquel", cascade = CascadeType.ALL)
    @ToString.Exclude

    private AnaquelLineaVistaSuperiorConfiguracion vistaSuperiorConfiguracion;

    @OneToOne(mappedBy = "anaquel", cascade = CascadeType.ALL)
    @ToString.Exclude

    private AnaquelLineaVistaFrontalConfiguration vistaFrontalConfiguracion;

    @OneToMany
    @ToString.Exclude
    private List<AnaquelLineaCeldas> anaquelLineaCeldas;

    @OneToMany
    @ToString.Exclude
    private List<AnaquelLineaCeldasSubdivisions> subdivisions;
}
