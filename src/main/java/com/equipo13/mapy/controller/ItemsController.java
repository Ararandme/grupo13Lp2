package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.DtoSkuAndDataLogista;
import com.equipo13.mapy.entities.items.Sku;
import com.equipo13.mapy.entities.items.SkuDataLogistica;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemsController {

    @GetMapping("/item-table")
    public String getItemTable(Model model) {
        initLoader(model);
        return "item-data/item_table";
    }

    private void initLoader(Model model){
        model.addAttribute("skuAndDataLogistica",
                new DtoSkuAndDataLogista(new Sku(), new SkuDataLogistica()));
    }

}
