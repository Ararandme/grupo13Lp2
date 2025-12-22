package com.equipo13.mapy.repositories.anaquel;

import com.equipo13.mapy.entities.anaquel.AnaquelLineaCelda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnaquelCeldaRepository extends JpaRepository<AnaquelLineaCelda, Integer> {
    List<AnaquelLineaCelda> findByAnaquelId(int id);
}
