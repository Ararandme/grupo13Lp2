package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.WarehouseDto;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.entities.warehouse.WarehouseConfiguration;
import com.equipo13.mapy.service.warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WarehouseController {

    //injection through the RequiredArg annotation
    private final WarehouseService warehouseService;


    @GetMapping("/warehouse-forms")
    public String warehouseForms(Model model) {
        model.addAttribute("warehouseDto",
                new WarehouseDto(new Warehouse(),new WarehouseConfiguration()));

        return "warehouse/warehouse_form_dashboard";
    }

    @GetMapping("/show-mappy")
    public String showWarehouse(Model model) {
        model.addAttribute("warehouses",warehouseService.getAllWarehouseJoin());
    return "warehouse/show_warehouse";
    }

    @PostMapping("warehouse-forms/warehouse-form")
    public String warehouseForm(WarehouseDto warehouseDto, Model model) {
    warehouseService.saveWarehouseDto(warehouseDto);

    return "redirect:/warehouse-forms";
    }
}
