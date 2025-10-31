package com.equipo13.mapy.repositories.user;

import com.equipo13.mapy.entities.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
