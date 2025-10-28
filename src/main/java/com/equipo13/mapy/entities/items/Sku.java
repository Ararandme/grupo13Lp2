package com.equipo13.mapy.entities.items;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Sku {

    @Id
    private int id;

    private String descripcion;
    private String thumbnail;
    private LocalDate fechaIngreso;
    private boolean estado; //bloqueado o no

  @OneToMany
  private List<SkuKardex> skuKardexs;

  @OneToOne
  private SkuDataLogistica skuDataLogistica;



}
