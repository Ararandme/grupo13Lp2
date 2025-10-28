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
    private int id;

    private int index;
    private boolean estado;//if is block or not



    @ManyToOne
    private Nave nave;

    @OneToOne
    private AnaquelLineaVistaSuperiorConfiguracion vistaSuperiorConfiguracion;

    @OneToOne
    private AnaquelLineaVistaFrontalConfiguration vistaFrontalConfiguracion;

    @OneToMany
    private List<AnaquelLineaCeldas> anaquelLineaCeldas;

    @OneToMany
    private List<AnaquelLineaCeldasSubdivisions> subdivisions;
}
