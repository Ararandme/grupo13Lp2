package com.equipo13.mapy.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnaquelDto {
    private Long naveId;
    private Long superiorConfigId;
    private Long frontalConfigId;
    private boolean selected;
}
