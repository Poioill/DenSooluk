package com.example.denSooluk.Controllers;

import com.example.denSooluk.Entity.mainPage.MoreOpportunity;
import com.example.denSooluk.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MainPageController {
    private final IntroductionRepo introductionRepo;
    private final BenefitRepo benefitRepo;
    private final PersonalCabRepo personalCabRepo;
    private final FeedbackRepo feedbackRepo;
    private final MoreOpportunityRepo moreOpportunityRepo;

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("value", introductionRepo.findAll());
        model.addAttribute("benefits", benefitRepo.findAll());
        model.addAttribute("personal", personalCabRepo.findAll());
        model.addAttribute("feedback", feedbackRepo.findAll());
        model.addAttribute("opportunity", moreOpportunityRepo.findAll());
        return "home";
    }

    @GetMapping("/check-page")
    public String check(Model model) {
        return "check-page";
    }
}
