package com.example.denSooluk.Controllers;


import com.example.denSooluk.Entity.Answers;
import com.example.denSooluk.Entity.User;
import com.example.denSooluk.Entity.UserQuestions;
import com.example.denSooluk.Services.UserQuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserQuestionsService userQuestionsService;

    @GetMapping("/user/{user}")
    public String personal(@PathVariable("user") User user, Model model){
        model.addAttribute("user", user);
        return "personalPage/user";
    }

    @PostMapping("/add")
    public String makeNote(UserQuestions userQuestions, Answers answers){
        userQuestionsService.makeQuestions(userQuestions);
        return "redirect:/";
    }
}
