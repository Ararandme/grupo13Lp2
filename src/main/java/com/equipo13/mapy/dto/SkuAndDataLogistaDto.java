package com.equipo13.mapy.dto;

import com.equipo13.mapy.entities.items.Sku;
import com.equipo13.mapy.entities.items.SkuDataLogistica;

public record SkuAndDataLogistaDto(
        Sku sku,
        SkuDataLogistica skuDataLogistica
) {
}
