package com.equipo13.mapy.repositories.nave;

import com.equipo13.mapy.entities.nave.Nave;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NaveRepository extends JpaRepository<Nave, Integer> {

    List<Nave> findAllByWarehouse(Warehouse warehouse);
}
