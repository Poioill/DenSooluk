package com.example.denSooluk.Controllers;

import com.example.denSooluk.Repositories.*;
import com.example.denSooluk.Services.UserQuestionsService;
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
    private final UserQuestionsService userQuestionsService;

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("value", introductionRepo.findAll());
        model.addAttribute("benefits", benefitRepo.findAll());
        model.addAttribute("personal", personalCabRepo.findAll());
        model.addAttribute("feedback", feedbackRepo.findAll());
        model.addAttribute("opportunity", moreOpportunityRepo.findAll());
        return "home";
    }

    @GetMapping("/questions")
    public String answers(Model model){
        model.addAttribute("answer", userQuestionsService.allUserQuestions());
        return "answer";
    }
}
