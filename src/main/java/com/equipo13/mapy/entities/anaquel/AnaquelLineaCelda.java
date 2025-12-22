package com.equipo13.mapy.entities.anaquel;
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
public class AnaquelLineaCelda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double xPosition;
    private double yPosition;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anaquel_id")
    @ToString.Exclude
    private Anaquel anaquel;


    @OneToMany(mappedBy = "anaquelLineaCelda", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AnaquelLineaCeldasSubdivision> celdasSubdivisions;


}
