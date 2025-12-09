package com.equipo13.mapy.service.nave;

import com.equipo13.mapy.entities.nave.Nave;
import com.equipo13.mapy.entities.nave.NaveConfiguration;
import com.equipo13.mapy.entities.warehouse.Warehouse;
import com.equipo13.mapy.repositories.nave.NaveConfigurationRepository;
import com.equipo13.mapy.repositories.nave.NaveRepository;
import com.equipo13.mapy.service.warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NaveService {

    private final NaveRepository naveRepository;
    private final NaveRepository naveConfiguration;
    private final WarehouseService warehouseService;
    private final NaveConfigurationRepository naveConfigurationRepository;


    public Nave initForms(){
        var nave = new Nave();
        nave.setNaveConfiguration(new NaveConfiguration());
        return nave;
    }


    public void saveNaveJoin(Nave nave, int  id){


        NaveConfiguration config  = nave.getNaveConfiguration();
        var warehouse = warehouseService.getWarehouseById(id);

        if (config != null){
            config.setNave(nave);
            nave.setNaveConfiguration(config);
        }
        nave.setWarehouse(warehouse);
        naveRepository.save(nave);
    }

    public List<Nave> getNaves() {
        return naveRepository.findAll();
    }

    public List<Nave>getAllnaveByWarehouseId(int id){
        return naveRepository.findAllByWarehouse(warehouseService.getWarehouseById(id));
    }

    public void deleteNaveById(int id){
        naveRepository.deleteById(id);
    }

    public Nave getNaveById(int id){
        return  naveRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("No se encontro el nave" + id));
    }
    public NaveConfiguration getNaveConfigurationById(int id){
        return naveConfigurationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el naveConfiguration" + id));
    }



    public void updateNave(Nave naveFromForm,int option){

        //nave form is the detach modal
        Nave naveDb = getNaveById(Math.toIntExact(naveFromForm.getId()));
        naveDb.setNaveAlias(naveFromForm.getNaveAlias());
        naveDb.setEstado(naveFromForm.isEstado());


        var warehouse = warehouseService.getWarehouseById(option);
        naveDb.setWarehouse(warehouse);

        int naveConfigurationId = naveDb.getNaveConfiguration().getId();
        NaveConfiguration configDb =  getNaveConfigurationById(naveConfigurationId);
        NaveConfiguration configForm = naveFromForm.getNaveConfiguration();

        if (configForm != null){
            configDb.setLenghtX(configForm.getLenghtX());
            configDb.setWidthY(configForm.getWidthY());
            configDb.setHeightZ(configForm.getHeightZ());
            configDb.setMarginSizeLeftX(configForm.getMarginSizeLeftX());
            configDb.setMarginSizeRightX(configForm.getMarginSizeRightX());
            configDb.setMarginSizeTopY(configForm.getMarginSizeTopY());
            configDb.setMarginSizeBottonY(configForm.getMarginSizeBottonY());
            configDb.setPasilloWidth(configForm.getPasilloWidth());
            configDb.setPasilloQuantity(configForm.getPasilloQuantity());
            configDb.setFechaActualzicion(LocalDate.now());
        }
        naveDb.setNaveConfiguration(configDb);
        naveRepository.save(naveDb);
    }


}
