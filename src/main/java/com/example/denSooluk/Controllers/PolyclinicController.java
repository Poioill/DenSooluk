package com.example.denSooluk.Controllers;

import com.example.denSooluk.Entity.polyclinicModels.Polyclinic;
import com.example.denSooluk.Repositories.RegionRepo;
import com.example.denSooluk.Services.CityService;
import com.example.denSooluk.Services.PolyclinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PolyclinicController {
    private final CityService cityService;
    private final RegionRepo regionRepo;
    private final PolyclinicService polyclinicService;

    @GetMapping("/polyclinics")
    public String polyclinics(@RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "selectRegion", required = false) Long regionId,
                              Model model) {
        model.addAttribute("region", regionRepo.findAll());
        model.addAttribute("cities", cityService.listCity());
        model.addAttribute("pol", polyclinicService.listPolyclinicSearch(name, regionId));
        return "polyclinic";
    }

    @GetMapping("/polyclinics/{id}")
    public String polyclinicInfo(@PathVariable Long id, Model model) {
        model.addAttribute("pol", polyclinicService.getPolyclinicById(id));
        return "poly-info";
    }

    @PostMapping("/polyclinics/{id}/delete")
    public String polyclinicDelete(@PathVariable Long id, Model model) {
        polyclinicService.deletePolyclinic(id);
        return "redirect:/admin";
    }

    @GetMapping("/polyclinics/{id}/update")
    public String polyclinicUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("pol", polyclinicService.getPolyclinicById(id));
        model.addAttribute("city", cityService.listCity());
        return "poly-update";
    }

    @PostMapping("/polyclinics/{id}/update")
    public String updatePolyclinic(@ModelAttribute("pol") Polyclinic polyclinic,
                                   @RequestParam("selectUpdate") Long cityId,
                                   Model model) {
        polyclinicService.addPolyclinic(polyclinic, cityId);
        return "redirect:/admin";
    }
}
