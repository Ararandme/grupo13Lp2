package com.equipo13.mapy.repositories.warehouse;

import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.entities.warehouse.WarehouseConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseConfigurationRepository  extends JpaRepository<WarehouseConfiguration, Long> {


}
