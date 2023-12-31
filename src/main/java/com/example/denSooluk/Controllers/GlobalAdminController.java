package com.example.denSooluk.Controllers;

import com.example.denSooluk.Entity.Citizen;
import com.example.denSooluk.Entity.Role;
import com.example.denSooluk.Entity.User;
import com.example.denSooluk.Entity.polyclinicModels.City;
import com.example.denSooluk.Entity.polyclinicModels.Polyclinic;
import com.example.denSooluk.Repositories.RegionRepo;
import com.example.denSooluk.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class GlobalAdminController {
    private final CityService cityService;
    private final RegionRepo regionRepo;
    private final PolyclinicService polyclinicService;
    private final UserService userService;
    private final CitizenService citizenService;
    private final ServicesMedService servicesMedService;
    private final ServicesItemsService servicesItemsService;
    private final UserQuestionsService userQuestionsService;

    @GetMapping("/admin")
    public String adminPage(@AuthenticationPrincipal User user, Model model) {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.RECEPTIONIST);
        roles.add(Role.USER);
        roles.add(Role.ADMIN);
        roles.add(Role.STAFF);
        model.addAttribute("region", regionRepo.findAll());
        model.addAttribute("city", cityService.listCity());
        model.addAttribute("citizens", citizenService.allCitizens());
        model.addAttribute("pol", polyclinicService.listPolyclinic());
        model.addAttribute("services", servicesItemsService.allServicesItems());
        model.addAttribute("serv", servicesMedService.listOfServices());
        model.addAttribute("roles", roles);
        model.addAttribute("users", userService.list());
        model.addAttribute("usr", user);
        model.addAttribute("questions", userQuestionsService.allUserQuestions());
        return "personalPage/globalAdmin";
    }

    @PostMapping("/city/add")
    public String createCity(@ModelAttribute("region") City city,
                             @RequestParam("select") Long regionId) {
        cityService.addCity(city, regionId);
        return "redirect:/admin";
    }

    @PostMapping("/citizen")
    public String addCitizen(Model model, Citizen citizen, @RequestParam("selectGender") String gender) {
        citizenService.addCitizen(citizen, gender);
        return "redirect:/admin";
    }

    @PostMapping("/polyclinic/add")
    public String createPolyclinic(@ModelAttribute("city") Polyclinic polyclinic,
                                   @RequestParam("select") Long cityId) {
        polyclinicService.addPolyclinic(polyclinic, cityId);
        return "redirect:/admin";
    }
}
