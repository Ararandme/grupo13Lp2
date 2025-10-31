package com.equipo13.mapy.entities.user;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.OneToOne;
import org.springframework.boot.context.properties.bind.DefaultValue;


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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
