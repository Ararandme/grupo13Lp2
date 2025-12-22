package com.equipo13.mapy.repositories.anaquel;

import com.equipo13.mapy.entities.anaquel.AnaquelLineaVistaFrontalConfiguration;
import com.equipo13.mapy.entities.anaquel.AnaquelLineaVistaSuperiorConfiguracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnaquelSuperiorConfigurationRepository extends JpaRepository<AnaquelLineaVistaSuperiorConfiguracion,Integer> {
}
