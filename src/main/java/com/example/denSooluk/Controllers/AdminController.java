package com.example.denSooluk.Controllers;

import com.example.denSooluk.Entity.polyclinicModels.City;
import com.example.denSooluk.Entity.polyclinicModels.Polyclinic;
import com.example.denSooluk.Repositories.RegionRepo;
import com.example.denSooluk.Services.CityService;
import com.example.denSooluk.Services.PolyclinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class AdminController {
    private final CityService cityService;
    private final RegionRepo regionRepo;
    private final PolyclinicService polyclinicService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("region", regionRepo.findAll());
        model.addAttribute("city", cityService.listCity());
        model.addAttribute("pol", polyclinicService.listPolyclinic());
        return "personalPage/admin";
    }

    @PostMapping("/city/add")
    public String createCity(@ModelAttribute("region") City city,
                             @RequestParam("select") Long regionId) {
        cityService.addCity(city, regionId);
        return "redirect:/admin";
    }

    @PostMapping("/polyclinic/add")
    public String createPolyclinic(@ModelAttribute("city") Polyclinic polyclinic,
                                   @RequestParam("select") Long cityId) {
        polyclinicService.addPolyclinic(polyclinic, cityId);
        return "redirect:/admin";
    }
}
