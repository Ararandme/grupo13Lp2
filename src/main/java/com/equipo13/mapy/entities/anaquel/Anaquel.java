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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "superior_config_id")
    @ToString.Exclude
    private AnaquelLineaVistaSuperiorConfiguracion SuperiorConfiguracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frontal_config_id")
    @ToString.Exclude
    private AnaquelLineaVistaFrontalConfiguration FrontalConfiguracion;

    @OneToMany(mappedBy = "anaquel", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AnaquelLineaCelda> anaquelLineaCeldas;


}
