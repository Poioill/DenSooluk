package com.example.denSooluk.Services;

import com.example.denSooluk.Repositories.ServicesMedRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.denSooluk.Entity.polyclinicModels.ServicesMed;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicesMedService {
    private final ServicesMedRepo servicesMedRepo;

    public List<ServicesMed> listOfServices(){
        return servicesMedRepo.findAll();
    }


}
