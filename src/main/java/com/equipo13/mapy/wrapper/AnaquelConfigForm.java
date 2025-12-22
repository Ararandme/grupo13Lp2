package com.equipo13.mapy.wrapper;

import com.equipo13.mapy.dto.AnaquelDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class AnaquelConfigForm {
    private Long warehouseId;
    private List<AnaquelDto> anaqueles = new ArrayList<>();
}
