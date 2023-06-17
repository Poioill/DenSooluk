package com.example.denSooluk.Controllers;


import com.example.denSooluk.Entity.User;
import com.example.denSooluk.Entity.UserModels.UserNotes;
import com.example.denSooluk.Services.UserNotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserNotesService userNotesService;

    @GetMapping("/user/{user}")
    public String personal(@PathVariable("user") User user, Model model){
        model.addAttribute("notes", userNotesService.allUserNotes());
        return "personalPage/user";
    }

    @PostMapping("/user/add")
    public String makeNote(Principal principal, UserNotes userNotes){
        userNotesService.makeNotes(principal, userNotes);
        return "redirect:/user/{user}";
    }

    
}
