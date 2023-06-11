package com.example.denSooluk.Controllers;

import com.example.denSooluk.Repositories.introductionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MainPageController {
    private final introductionRepo introductionRepo;

    @GetMapping("/")
    public String hello(Model model) {
            model.addAttribute("value", introductionRepo.findAll());
            return "home";
    }

    @GetMapping("/check-page")
    public String check(Model model) {
        return "check-page";
    }
}
