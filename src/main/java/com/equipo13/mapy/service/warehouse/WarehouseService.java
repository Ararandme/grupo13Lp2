package com.equipo13.mapy.service.warehouse;

import com.equipo13.mapy.dto.WarehouseDto;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.entities.warehouse.WarehouseConfiguration;
import com.equipo13.mapy.repositories.warehouse.WarehouseConfigurationRepository;
import com.equipo13.mapy.repositories.warehouse.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseConfigurationRepository warehouseConfigurationRepository;
    public void saveWarehouseDto(WarehouseDto warehouseDto) {
        Warehouse warehouse = warehouseDto.warehouse();
        WarehouseConfiguration warehouseConfiguration = warehouseDto.warehouseConfiguration();

        warehouse.setWarehousesConfiguration(warehouseConfiguration);
        warehouseConfiguration.setWarehouse(warehouse);

        warehouseRepository.save(warehouse);

    }

    public List<Warehouse> getAllWarehouseJoin(){
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(Long id) {

        return warehouseRepository.findById(id);
    }

}
