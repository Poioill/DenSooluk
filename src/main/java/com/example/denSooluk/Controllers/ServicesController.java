package com.example.denSooluk.Controllers;

import com.example.denSooluk.Entity.polyclinicModels.ServicesItems;
import com.example.denSooluk.Entity.polyclinicModels.ServicesMed;
import com.example.denSooluk.Services.ServicesItemsService;
import com.example.denSooluk.Services.ServicesMedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ServicesController {
    private final ServicesMedService servicesMedService;
    private final ServicesItemsService servicesItemsService;

    @GetMapping("/services")
    public String services(Model model){
        model.addAttribute("services", servicesItemsService.allServicesItems());
        return "service";
    }

    @PostMapping("/serv")
    public String serv(Model model, ServicesMed servicesMed, @RequestParam("selectServ") Long servicesItemsId){
        servicesMedService.saveService(servicesMed, servicesItemsId);
        return "redirect:/admin";
    }

    @GetMapping("/serv/{id}")
    public String servicesMore(@PathVariable Long id, Model model){
        model.addAttribute("serviceInfo", servicesMedService.getServById(id));
        return "serv-info";
    }

    @PostMapping("/serv/{id}/delete")
    public String servDelete(ServicesMed servicesMed){
        servicesMedService.deleteServ(servicesMed);
        return "redirect:/admin";
    }

    @GetMapping("/serv/{id}/update")
    public String servUpdate(@PathVariable Long id, Model model){
        model.addAttribute("servItems", servicesItemsService.allServicesItems());
        model.addAttribute("services", servicesMedService.getServById(id));
        return "serv-update";
    }

    @PostMapping("/serv/{id}/update")
    public String servsUpdate(@ModelAttribute("service") ServicesMed servicesMed,
                              @RequestParam("selectServ") Long servicesItemsId) {
        servicesMedService.saveService(servicesMed, servicesItemsId);
        return "redirect:/admin";
    }




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
