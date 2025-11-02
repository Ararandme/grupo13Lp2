package com.equipo13.mapy.dto;

import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.entities.warehouse.WarehouseConfiguration;

public record WarehouseDto(
        Warehouse warehouse,
        WarehouseConfiguration warehouseConfiguration
) {
}
