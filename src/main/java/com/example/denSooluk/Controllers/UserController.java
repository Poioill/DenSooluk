package com.example.denSooluk.Controllers;


import com.example.denSooluk.Entity.UserModels.UserNotes;
import com.example.denSooluk.Services.UserNotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserNotesService userNotesService;

    @GetMapping("/user")
    public String personal(Model model){
        model.addAttribute("notes", userNotesService.allUserNotes());
        return "personalPage/user";
    }

    @PostMapping("/note")
    public String makeNote(UserNotes userNotes, Model model){
        userNotesService.makeNotes(userNotes);
        return "redirect:/user";
    }

    
}
