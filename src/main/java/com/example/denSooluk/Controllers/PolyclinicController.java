package com.example.denSooluk.Controllers;

import com.example.denSooluk.Repositories.RegionRepo;
import com.example.denSooluk.Services.CityService;
import com.example.denSooluk.Services.PolyclinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PolyclinicController {
    private final CityService cityService;
    private final RegionRepo regionRepo;
    private final PolyclinicService polyclinicService;

    @GetMapping("/polyclinics")
    public String polyclinics(@RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "selectRegion", required = false) Long regionId,
                              Model model){
        model.addAttribute("region", regionRepo.findAll());
        model.addAttribute("cities", cityService.listCity());
        model.addAttribute("pol", polyclinicService.listPolyclinicSearch(name, regionId));
        return "polyclinic";
    }
}
