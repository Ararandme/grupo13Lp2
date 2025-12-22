package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.AnaquelDto;
import com.equipo13.mapy.dto.MapyDto;
import com.equipo13.mapy.entities.anaquel.AnaquelLineaVistaFrontalConfiguration;
import com.equipo13.mapy.entities.anaquel.AnaquelLineaVistaSuperiorConfiguracion;
import com.equipo13.mapy.entities.nave.Nave;
import com.equipo13.mapy.service.anaquel.AnaquelService;
import com.equipo13.mapy.service.map.MapService;
import com.equipo13.mapy.service.nave.NaveService;
import com.equipo13.mapy.service.warehouse.WarehouseService;
import com.equipo13.mapy.wrapper.AnaquelConfigForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MapyController {

    private final AnaquelService anaquelService;
    private final WarehouseService warehouseService;
    private final NaveService naveService;
    private final MapService mapService;

    @GetMapping("/mapy/configAnaqueles")
    public String configAnaqueles(Model model){
        var mapyDto = new MapyDto();
        mapyDto.setAnaquelLineaVistaSuperiorConfiguracion(new AnaquelLineaVistaSuperiorConfiguracion());
        mapyDto.setAnaquelLineaVistaFrontalConfiguration(new AnaquelLineaVistaFrontalConfiguration());
        mapyDto.setAnaquelLineaVistaSuperiorConfiguraciones(anaquelService.getAnaquelSuperiorConfigs());
        mapyDto.setAnaquelLineaVistaFrontalConfigurationes(anaquelService.getAnaquelFrontalConfigs());

        model.addAttribute("mapyDto", mapyDto);

        return "mapy/configFrontalDashboard";
    }

    @PostMapping("/mapy/configSuperiorForm/save")
    public String saveConfigSuperiorForm(MapyDto dto){
        anaquelService.saveAnaquelSuperiorConfigWithDto(dto);

        return "redirect:/mapy/configAnaqueles";
    }
    @PostMapping("/mapy/configFrontalForm/save")
    public String saveConfigFrontalForm(MapyDto dto){
        anaquelService.saveAnaquelFrontalConfigWithDto(dto);
        return "redirect:/mapy/configAnaqueles";
    }

    @GetMapping("/mapy/setupMapList")
    public String setupMapList(Long warehouseId, Model model){

        model.addAttribute("warehouses", warehouseService.getAllWarehouseJoin());
        model.addAttribute("configSuperiors", anaquelService.getAnaquelSuperiorConfigs());
        model.addAttribute("configFrontals", anaquelService.getAnaquelFrontalConfigs());

        AnaquelConfigForm form = new AnaquelConfigForm();
        form.setWarehouseId(warehouseId);

        if (warehouseId != null){
            List<Nave> naves = naveService.getNaves();


            List<AnaquelDto> dtos = new ArrayList<>();
            for (Nave nave : naves) {
                AnaquelDto dto = new AnaquelDto();
                dto.setNaveId(nave.getId());
                dto.setSelected(true);
                dto.setSuperiorConfigId(0L);
                dto.setFrontalConfigId(0L);
                dtos.add(dto);
            }
            form.setAnaqueles(dtos);
        }
        model.addAttribute("form", form);
        return "mapy/setupMapList/mainSetupMapListView";
    }

    @PostMapping("/mapy/setupMapList/saveAnaquel")
    public String submit( AnaquelConfigForm form) {

        anaquelService.saveConfigurationToAnaquel(form);

        System.out.println(form);
        return "redirect:/mapy/setupMapList";
    }

    @GetMapping("mapy/printcode")
    public String printCode(Long warehouseId,Model model){
        model.addAttribute("warehouses", warehouseService.getAllWarehouseJoin());

        if (warehouseId != null){

            model.addAttribute("mapList", anaquelService.createMapList(Math.toIntExact(warehouseId)));
        }

        return "mapy/printcode";
    }



}
