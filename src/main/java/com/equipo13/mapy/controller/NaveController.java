package com.equipo13.mapy.controller;

import com.equipo13.mapy.entities.nave.Nave;
import com.equipo13.mapy.entities.nave.NaveConfiguration;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.service.nave.NaveService;
import com.equipo13.mapy.service.warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NaveController {
    final private NaveService naveService;
    final private WarehouseService warehouseService;


    @GetMapping("/nave-form")
    public String naveForms(Model model) {

        model.addAttribute("naves",naveService.getNaves() );
        model.addAttribute("warehouseList", warehouseService.getAllWarehouseJoin());
        model.addAttribute("nave", naveService.initForms());

        return "nave/nave-form";
    }

    @PostMapping("/nave-form/save")
    public String saveNave(Nave nave,int option ) {
        naveService.saveNaveJoin(nave, option);
        return "redirect:/nave-form";
    }

    @GetMapping("/nave/delete/{id}")
    public String deleteNave(@PathVariable Integer id, Model model) {
        naveService.deleteNaveById(id);
        return "redirect:/nave-form";
    }

    @GetMapping("/nave/edit/{id}")
    public String editNave(@PathVariable Integer id, Model model) {

        Nave nave = naveService.getNaveById(id);
        List<Warehouse> warehouseList = warehouseService.getAllWarehouseJoin();
        int warehouseListIndex = warehouseService.getWarehouseIndexById(nave);
        Warehouse warehouse = warehouseList.get(warehouseListIndex);
        warehouseList.remove(warehouse);

        model.addAttribute("warehouseListDefault",warehouse );
        model.addAttribute("warehouseList", warehouseList);
        model.addAttribute("nave",nave);
        return "nave/edit";
    }

    @PostMapping("/nave-form/edit")
    public String editNave(Nave nave,int option,Model model) {


        naveService.updateNave(nave,option);
        return "redirect:/nave-form";
    }







}
