package com.equipo13.mapy.dto;

import com.equipo13.mapy.entities.anaquel.AnaquelLineaVistaFrontalConfiguration;
import com.equipo13.mapy.entities.anaquel.AnaquelLineaVistaSuperiorConfiguracion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MapyDto {

    AnaquelLineaVistaSuperiorConfiguracion anaquelLineaVistaSuperiorConfiguracion;
    AnaquelLineaVistaFrontalConfiguration anaquelLineaVistaFrontalConfiguration;
    List<AnaquelLineaVistaSuperiorConfiguracion> anaquelLineaVistaSuperiorConfiguraciones;
    List<AnaquelLineaVistaFrontalConfiguration> anaquelLineaVistaFrontalConfigurationes;
}
