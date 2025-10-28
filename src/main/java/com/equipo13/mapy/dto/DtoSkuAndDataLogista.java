package com.equipo13.mapy.dto;

import com.equipo13.mapy.entities.items.Sku;
import com.equipo13.mapy.entities.items.SkuDataLogistica;

public record DtoSkuAndDataLogista(
        Sku sku,
        SkuDataLogistica skuDataLogistica
) {
}
