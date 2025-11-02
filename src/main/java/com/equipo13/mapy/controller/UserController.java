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

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    /*@RequiredArgsConstructor*/
    public UserController(UserRepository _userRepository,
                          UserProfileRepository _userProfileRepository) {
        this.userRepository = _userRepository;
        this.userProfileRepository = _userProfileRepository;
    }

    @GetMapping("/user-dashboard")
    public String getUserTable(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        model.addAttribute("userProfile",
                new UserProfileDto(new User(), new UserProfile()));
        return "user/user_dashboard";
    }

    @PostMapping("/user-dashboard/forms")
    public String getProfileForm(Model model, UserProfileDto dto) {

        User user = dto.user();
        UserProfile userProfile = dto.userProfile();

        dto.userProfile().setUser(user);
        dto.user().setUserProfile(userProfile);
        userRepository.save(user);


        return "redirect:/user-dashboard";
    }


}
