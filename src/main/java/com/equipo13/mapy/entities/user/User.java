package com.equipo13.mapy.entities.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class User {
    @Id
    private int id;

    private String password;

    private String username;

    private LocalDate fechaIngreso;

    @OneToOne
    private UserProfile userProfile;

}
