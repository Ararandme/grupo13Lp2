package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.SkuAndDataLogistaDto;
import com.equipo13.mapy.entities.items.Sku;
import com.equipo13.mapy.entities.items.SkuDataLogistica;
import com.equipo13.mapy.repositories.items.SkuDataLogisiticaRepository;
import com.equipo13.mapy.repositories.items.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemsController {

    @Autowired
    SkuRepository repository;

    @GetMapping("/item-table")
    public String getItemTable(Model model) {
        initLoader(model);
        return "item-data/item_table";
    }

    @PostMapping("/item-table/forms")
    public String postItemTable(SkuAndDataLogistaDto dto) {

        repository.save(dto.sku());
        return "redirect:/item-table";
    }



    private void initLoader(Model model){
        model.addAttribute("skuAndDataLogistica",
                new SkuAndDataLogistaDto(new Sku(), new SkuDataLogistica()));
    }



}
