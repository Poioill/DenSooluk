package com.example.denSooluk.Services;

import com.example.denSooluk.Entity.polyclinicModels.City;
import com.example.denSooluk.Entity.polyclinicModels.Region;
import com.example.denSooluk.Repositories.CityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityService {
    private final CityRepo cityRepo;

    public void addCity(City city, Long regionId) {
        Region region = new Region();
        region.setId(regionId);
        city.setRegion(region);
        cityRepo.save(city);
    }

    public List<City> listCity() {
        return cityRepo.findAll();
    }
    
}