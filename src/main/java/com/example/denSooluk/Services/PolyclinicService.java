package com.example.denSooluk.Services;

import com.example.denSooluk.Entity.polyclinicModels.City;
import com.example.denSooluk.Entity.polyclinicModels.Polyclinic;
import com.example.denSooluk.Repositories.PolyclinicRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PolyclinicService {
    private final PolyclinicRepo polyclinicRepo;

    public void addPolyclinic(Polyclinic polyclinic, Long cityId) {
        City city = new City();
        city.setId(cityId);
        polyclinic.setCity(city);
        polyclinic.setName(polyclinic.getName());
        polyclinic.setAddress(polyclinic.getAddress());
        polyclinic.setPhone(polyclinic.getPhone());
        polyclinic.setYear(polyclinic.getYear());
        polyclinic.setGraphic(polyclinic.getGraphic());
        polyclinicRepo.save(polyclinic);
    }

    public List<Polyclinic> listPolyclinic() {
        return polyclinicRepo.findAll();
    }

    public List<Polyclinic> listPolyclinicSearch(String name) {
        if (name != null)
            return polyclinicRepo.findPolyclinicByNameContainingIgnoreCase(name);
        return polyclinicRepo.findAll();
    }
}
