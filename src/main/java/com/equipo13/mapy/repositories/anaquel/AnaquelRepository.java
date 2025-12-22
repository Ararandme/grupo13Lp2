package com.equipo13.mapy.repositories.anaquel;

import com.equipo13.mapy.entities.anaquel.Anaquel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnaquelRepository extends JpaRepository<Anaquel, Integer> {

    List<Anaquel> findByNaveId(Long naveid);

}
