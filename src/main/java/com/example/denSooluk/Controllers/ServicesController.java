package com.example.denSooluk.Controllers;

import com.example.denSooluk.Entity.polyclinicModels.ServicesItems;
import com.example.denSooluk.Services.ServicesItemsService;
import com.example.denSooluk.Services.ServicesMedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ServicesController {
    private final ServicesMedService servicesMedService;
    private final ServicesItemsService servicesItemsService;

    @GetMapping("/services/{id}/update")
    public String serviceUpdate(@PathVariable Long id, Model model){
        model.addAttribute("services", servicesItemsService.getServicesItemById(id));
        return "service-update";
    }

    @PostMapping("/services/{id}/update")
    public String servicesUpdate(@ModelAttribute("service") ServicesItems servicesItems) {
        servicesItemsService.saveServicesItems(servicesItems);
        return "redirect:/admin";
    }

    @PostMapping("/services/{id}/delete")
    public String servicesDelete(ServicesItems servicesItems){
        servicesItemsService.deleteServiceItem(servicesItems);
        return "redirect:/admin";
    }

    @PostMapping("/services")
    public String servicesCreate(Model model, ServicesItems servicesItems){
        servicesItemsService.saveServicesItems(servicesItems);
        return "redirect:/admin";
    }


}
