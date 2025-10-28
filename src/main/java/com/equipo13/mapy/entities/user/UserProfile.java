package com.equipo13.mapy.entities.user;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.OneToOne;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class UserProfile {

    @Id
    private int id;
    private String nombre;
    private String apellidos;
    private String correos;


    @OneToOne
    private User user;
}
