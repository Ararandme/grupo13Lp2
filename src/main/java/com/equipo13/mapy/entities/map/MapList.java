package com.equipo13.mapy.entities.map;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class MapList {

    @Id
    private Long id;

    private int warehouseId;
    private int naveId;
    private int anaquelId;
    private int anaquelColumnaId;
    private int anaquelRowId;
    private int anaquelSubCeldaId;

}
