package com.equipo13.mapy.repositories.user;

import com.equipo13.mapy.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
