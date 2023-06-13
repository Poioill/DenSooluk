package com.example.denSooluk.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PolyclinicController {
    @GetMapping("/polyclinics")
    public String polyclinics(Model model){
        return "polyclinic";
    }
}
