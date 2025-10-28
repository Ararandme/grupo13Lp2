package com.equipo13.mapy.dto;

import com.equipo13.mapy.entities.user.User;
import com.equipo13.mapy.entities.user.UserProfile;

public record DtoUserProfile(
        User user,
        UserProfile userProfile
) {
}
