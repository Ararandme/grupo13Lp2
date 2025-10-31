package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.UserProfileDto;
import com.equipo13.mapy.entities.user.User;
import com.equipo13.mapy.entities.user.UserProfile;
import com.equipo13.mapy.repositories.user.UserProfileRepository;
import com.equipo13.mapy.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/user-profile")
    public String getUserTable(Model model) {
        model.addAttribute("userProfile",
                new UserProfileDto(new User(), new UserProfile()));
        return "user/user_table";
    }

    @PostMapping("/user-profile/forms")
    public String getProfileForm(Model model, UserProfileDto dto) {

        User user = dto.user();
        UserProfile userProfile = dto.userProfile();

        dto.userProfile().setUser(user);
        dto.user().setUserProfile(userProfile);
        userRepository.save(user);


        return "redirect:/user-profile";
    }


}
