package com.example.denSooluk.Services;

import com.example.denSooluk.Entity.polyclinicModels.ServicesItems;
import com.example.denSooluk.Repositories.ServicesItemsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicesItemsService {
    private final ServicesItemsRepo servicesItemsRepo;

    public List<ServicesItems> allServicesItems() {
        return servicesItemsRepo.findAll();
    }

    public ServicesItems getServicesItemById(Long id){
        return servicesItemsRepo.findById(id).orElseThrow();
    }

    public void saveServicesItems(ServicesItems servicesItems) {
        servicesItems.setTitle(servicesItems.getTitle());
        log.info("Saving new ServicesItems. Title: {}", servicesItems.getTitle());
        servicesItemsRepo.save(servicesItems);
    }

    public void deleteServiceItem(ServicesItems servicesItems){
        servicesItemsRepo.deleteById(servicesItems.getId());
    }
}
