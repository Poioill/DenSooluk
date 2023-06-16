package com.example.denSooluk.Services;

import com.example.denSooluk.Entity.polyclinicModels.ServicesItems;
import com.example.denSooluk.Entity.polyclinicModels.ServicesMed;
import com.example.denSooluk.Repositories.ServicesMedRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicesMedService {
    private final ServicesMedRepo servicesMedRepo;

    public List<ServicesMed> listOfServices(){
        return servicesMedRepo.findAll();
    }

    public void saveService(ServicesMed servicesMed, Long servItemsId){
        ServicesItems servicesItems = new ServicesItems();
        servicesItems.setId(servItemsId);
        servicesMed.setServicesItems(servicesItems);
        servicesMed.setName(servicesMed.getName());
        log.info("Saving new ServicesItems. Title: {}", servicesMed.getName());
        servicesMedRepo.save(servicesMed);
    }

    public ServicesMed getServById(Long id){
        return servicesMedRepo.findById(id).orElseThrow();
    }
    public void deleteServ(ServicesMed servicesMed){
        servicesMedRepo.deleteById(servicesMed.getId());
    }

}
