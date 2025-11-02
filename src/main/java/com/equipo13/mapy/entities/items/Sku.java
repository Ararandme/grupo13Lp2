package com.equipo13.mapy.entities.items;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Sku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String thumbnail;
    private LocalDate fechaIngreso;
    private boolean estado; //bloqueado o no

  @OneToMany
  @ToString.Exclude
  private List<SkuKardex> skuKardexs;

  @OneToOne(mappedBy = "sku", cascade = CascadeType.ALL)
  @ToString.Exclude
  private SkuDataLogistica skuDataLogistica;



}
