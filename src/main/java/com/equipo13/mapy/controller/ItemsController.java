package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.SkuAndDataLogistaDto;
import com.equipo13.mapy.entities.items.Sku;
import com.equipo13.mapy.entities.items.SkuDataLogistica;
import com.equipo13.mapy.repositories.items.SkuDataLogisiticaRepository;
import com.equipo13.mapy.repositories.items.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("dto")
public class ItemsController {

    @Autowired
    SkuRepository skuRep;

    @Autowired
    SkuDataLogisiticaRepository skuDataLogisiticaRep;

    @GetMapping("/item-table")
    public String getItemTable(Model model) {
        model.addAttribute("skuAndDataLogistica",
                new SkuAndDataLogistaDto(new Sku(), new SkuDataLogistica()));
        return "item-data/item_table";
    }

    @PostMapping("/item-table/forms")
    public String postItemTable(@ModelAttribute SkuAndDataLogistaDto dto, Model model, SessionStatus status) {

        Sku sku = dto.sku();
        SkuDataLogistica skuDataLogistica = dto.skuDataLogistica();
        sku.setSkuDataLogistica(skuDataLogistica);
        skuDataLogisiticaRep.save(skuDataLogistica);

        skuRep.save(sku);
        status.setComplete();
        model.addAttribute("skuAndDataLogistica",
                new SkuAndDataLogistaDto(new Sku(), new SkuDataLogistica()));


        return "redirect:/item-table";
    }







}
