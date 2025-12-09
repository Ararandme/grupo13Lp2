package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.WarehouseDto;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.entities.warehouse.WarehouseConfiguration;
import com.equipo13.mapy.service.nave.NaveService;
import com.equipo13.mapy.service.warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WarehouseController {

    //injection through the RequiredArg annotation
    private final WarehouseService warehouseService;
    private final NaveService naveService;

    @GetMapping("/warehouse-forms")
    public String warehouseForms(Model model) {
        model.addAttribute("warehouseDto",
                new WarehouseDto(new Warehouse(),new WarehouseConfiguration()));

        return "warehouse/warehouse_form_dashboard";
    }

    @PostMapping("warehouse-forms/warehouse-form")
    public String warehouseForm(WarehouseDto warehouseDto, Model model) {
    warehouseService.saveWarehouseDto(warehouseDto);

    return "redirect:/warehouse-forms";
    }

    @GetMapping("/show-mappy")
    public String showWarehouse(Model model,Integer option) {

        model.addAttribute("warehouses",warehouseService.getAllWarehouseJoin());
        //change for a proper dto later to not  send the full join
        if (option != null){
            model.addAttribute("warehousejoin",warehouseService.getWarehouseById(option));
            model.addAttribute("naves",naveService.getAllnaveByWarehouseId(option));
        }

        return "warehouse/show_warehouse";
    }

    @GetMapping("warehouse/delete/{id}")
    public String deleteWarehouse(@PathVariable Integer id) {
        warehouseService.deleteWarehouseById(id);
        return "redirect:/warehouse-forms";
    }




}
