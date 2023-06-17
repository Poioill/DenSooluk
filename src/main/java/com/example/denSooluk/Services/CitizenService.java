package com.example.denSooluk.Services;

import com.example.denSooluk.Entity.Citizen;
import com.example.denSooluk.Repositories.CitizenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenService {
    private final CitizenRepo citizenRepo;

    public void addCitizen(Citizen citizen, String gender){
        citizen.setName(citizen.getName());
        citizen.setLastName(citizen.getLastName());
        citizen.setGender(gender);
        citizen.setPersonalId(citizen.getPersonalId());
        citizenRepo.save(citizen);
    }

    public List<Citizen> allCitizens(){
        return citizenRepo.findAll();
    }
}
