package com.example.denSooluk.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ReceptionController {
    @GetMapping("/reception")
    public String reception(Model model){
        return "personalPage/receptionist";
    }
}
