package com.equipo13.mapy.service.warehouse;

import com.equipo13.mapy.dto.WarehouseDto;
import com.equipo13.mapy.entities.nave.Nave;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.entities.warehouse.WarehouseConfiguration;
import com.equipo13.mapy.repositories.warehouse.WarehouseConfigurationRepository;
import com.equipo13.mapy.repositories.warehouse.WarehouseRepository;
import com.equipo13.mapy.service.nave.NaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseConfigurationRepository warehouseConfigurationRepository;

    public int getWarehouseIndexById(Nave nave){
        int warehouseId = Math.toIntExact(nave.getWarehouse().getId());
        return getAllWarehouseJoin().indexOf(getWarehouseById(warehouseId >= 0 ? warehouseId : 0));
    }


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

    public Warehouse getWarehouseById(int id) {
        if(id >= 0){
            return warehouseRepository.findById(Long.valueOf(id));
        }
        return null;
    }

    public void deleteWarehouseById(int id) {
        warehouseRepository.deleteById(id);

    }

}
