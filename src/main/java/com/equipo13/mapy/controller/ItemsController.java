package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.SkuAndDataLogistaDto;
import com.equipo13.mapy.entities.items.Sku;
import com.equipo13.mapy.entities.items.SkuDataLogistica;
import com.equipo13.mapy.repositories.items.SkuDataLogisiticaRepository;
import com.equipo13.mapy.repositories.items.SkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemsController {


    private final SkuRepository skuRep;
    private final SkuDataLogisiticaRepository skuDataLogisiticaRep;

    @GetMapping("/item-dashboard")
    public String getItemTable(Model model) {
        List<Sku> skus = skuRep.findAll();

        model.addAttribute("skuAndDataLogistica",
                new SkuAndDataLogistaDto(new Sku(), new SkuDataLogistica()));
        model.addAttribute("skus", skus);
        return "item-data/item_dashboard";
    }

    @PostMapping("/item-dashboard/forms")
    public String postItemTable(@ModelAttribute SkuAndDataLogistaDto dto) {

        Sku sku = dto.sku();
        SkuDataLogistica skuDataLogistica = dto.skuDataLogistica();
        skuDataLogistica.setSku(sku);
        sku.setSkuDataLogistica(skuDataLogistica);
        skuRep.save(sku);

        return "redirect:/item-dashboard";
    }








}
