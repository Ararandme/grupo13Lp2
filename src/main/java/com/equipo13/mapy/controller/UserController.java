package com.equipo13.mapy.controller;

import com.equipo13.mapy.dto.DtoUserProfile;
import com.equipo13.mapy.entities.user.User;
import com.equipo13.mapy.entities.user.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user-profile")
    public String getUserTable(Model model) {
        initLoader(model);
        return "user/user_table";
    }

    private void initLoader(Model model){
        model.addAttribute("userProfile",
                new DtoUserProfile(new User(), new UserProfile()));
    }
}
