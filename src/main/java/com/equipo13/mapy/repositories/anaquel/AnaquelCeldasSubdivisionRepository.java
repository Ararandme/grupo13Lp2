package com.equipo13.mapy.repositories.anaquel;

import com.equipo13.mapy.entities.anaquel.AnaquelLineaCeldasSubdivision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnaquelCeldasSubdivisionRepository extends JpaRepository<AnaquelLineaCeldasSubdivision, Integer> {

    List<AnaquelLineaCeldasSubdivision> findByAnaquelLineaCeldaId(int id);
}
