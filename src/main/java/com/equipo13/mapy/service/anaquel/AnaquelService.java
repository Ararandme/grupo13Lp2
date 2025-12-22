package com.equipo13.mapy.service.anaquel;

import com.equipo13.mapy.dto.AnaquelDto;
import com.equipo13.mapy.dto.MapyDto;
import com.equipo13.mapy.entities.anaquel.*;
import com.equipo13.mapy.entities.map.MapList;
import com.equipo13.mapy.entities.nave.Nave;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.repositories.anaquel.*;
import com.equipo13.mapy.service.map.MapService;
import com.equipo13.mapy.service.nave.NaveService;
import com.equipo13.mapy.service.warehouse.WarehouseService;
import com.equipo13.mapy.wrapper.AnaquelConfigForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnaquelService {

    private final AnaquelRepository anaquelRepository;
    private final AnaquelCeldaRepository celdaRepository;
    private final AnaquelCeldasSubdivisionRepository celdasSubdivisionRepository;
    private final AnaquelSuperiorConfigurationRepository superiorConfigurationRepository;
    private final AnaquelFrontalConfigurationRepository frontalConfigurationRepository;
    private final NaveService naveService;
    private final WarehouseService warehouseService;
    private final AnaquelCeldasSubdivisionRepository anaquelCeldasSubdivisionRepository;
    private final MapService mapService;

    public void saveAnaquelFrontalConfigWithDto(MapyDto dto){

        var frontal = dto.getAnaquelLineaVistaFrontalConfiguration();
        frontalConfigurationRepository.save(frontal);

    }
    public void saveAnaquelSuperiorConfigWithDto(MapyDto dto){

        var superior = dto.getAnaquelLineaVistaSuperiorConfiguracion();
            superiorConfigurationRepository.save(superior);

    }

    public List<AnaquelLineaVistaFrontalConfiguration> getAnaquelFrontalConfigs(){
        return frontalConfigurationRepository.findAll();
    }
    public List<AnaquelLineaVistaSuperiorConfiguracion> getAnaquelSuperiorConfigs(){
        return superiorConfigurationRepository.findAll();
    }

    @Transactional
    public void saveConfigurationToAnaquel(AnaquelConfigForm form){

        List<AnaquelDto> anaquelDto = form.getAnaqueles();

        List<Anaquel> anaqueles = new ArrayList<>();
        List<AnaquelLineaCelda> celdas = new ArrayList<>();
        List<AnaquelLineaCeldasSubdivision> subceldas = new ArrayList<>();

        int defaultSubCells = 1;

        for (var dto : anaquelDto) {

             //skip unchecked rows
            if (!dto.isSelected()) continue;

            Nave nave = naveService.getNaveById(Math.toIntExact(dto.getNaveId()));

            var superiorConfig = superiorConfigurationRepository
                    .findById(Math.toIntExact(dto.getSuperiorConfigId()))
                    .orElseThrow(() -> new IllegalArgumentException("Superior config invalida"));

            var frontalConfig = frontalConfigurationRepository
                    .findById(Math.toIntExact(dto.getFrontalConfigId()))
                    .orElseThrow(() -> new IllegalArgumentException("Frontal config invalida"));

            List<Anaquel> newAnaqueles = createAnaquelesPerNave(nave.getNaveConfiguration().getAnaquelQuantity());

            int aIndex = 1;
            for (var anaquel : newAnaqueles) {
                anaquel.setSuperiorConfiguracion(superiorConfig);
                anaquel.setFrontalConfiguracion(frontalConfig);
                anaquel.setNave(nave);
                anaquel.setAnaquelIndex(aIndex++);
            }

            // add them to the global list
            anaqueles.addAll(newAnaqueles);

            int frontalColumns =  frontalConfig.getColumnAmount();
            int frontalRows    =  frontalConfig.getRowAmount();

            //set anaqueles cells
            for (var anaquel : newAnaqueles) {
                for (int x = 0; x < frontalRows; x++) {
                    for (int y = 0; y < frontalColumns; y++) {
                        AnaquelLineaCelda celda = new AnaquelLineaCelda();
                        celda.setXPosition(x + 1);
                        celda.setYPosition(y + 1);
                        celda.setAnaquel(anaquel);
                        addSubCells(defaultSubCells, celda, subceldas);

                        celdas.add(celda);

                    }
                }
            }
        }



        anaquelRepository.saveAll(anaqueles);
        celdaRepository.saveAll(celdas);
        celdasSubdivisionRepository.saveAll(subceldas);



    }

    public List<MapList> createMapList(int warehouseId) {

        Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
        List<Nave> naves = naveService.getAllnaveByWarehouseId(warehouseId);

        List<MapList> mapList = new ArrayList<>();

        for (Nave nave : naves) {

            List<Anaquel> anaqueles = anaquelRepository.findByNaveId(nave.getId());

            for (Anaquel anaquel : anaqueles) {

                List<AnaquelLineaCelda> celdas = celdaRepository.findByAnaquelId(anaquel.getId());

                for (AnaquelLineaCelda celda : celdas) {

                    List<AnaquelLineaCeldasSubdivision> subceldas =
                            anaquelCeldasSubdivisionRepository.findByAnaquelLineaCeldaId(celda.getId());

                    for (AnaquelLineaCeldasSubdivision subcelda : subceldas) {

                        MapList map = new MapList();
                        map.setWarehouseId(warehouseId);
                        map.setNaveId(Math.toIntExact(nave.getId()));

                        map.setAnaquelId(anaquel.getAnaquelIndex());

                        map.setAnaquelRowId((int) celda.getXPosition());
                        map.setAnaquelColumnaId((int) celda.getYPosition());

                        map.setAnaquelSubCeldaId(Math.toIntExact(subcelda.getId()));

                        mapList.add(map);
                    }
                }
            }
        }

        return mapList;
    }

    private void addSubCells(int amount, AnaquelLineaCelda celda, List<AnaquelLineaCeldasSubdivision> out) {
        for (int i = 1; i <= amount; i++) {
            AnaquelLineaCeldasSubdivision sub = new AnaquelLineaCeldasSubdivision();
            sub.setAnaquelLineaCelda(celda);
            out.add(sub);
        }
    }



    private List<Anaquel> createAnaquelesPerNave(int anaquelQuantity){
        List<Anaquel> anaqueles = new ArrayList<>();
        for (int i = 0;i < anaquelQuantity; i++){
            Anaquel anaquel = new Anaquel();
            anaqueles.add(anaquel);
        }
        return anaqueles;
    }



}
