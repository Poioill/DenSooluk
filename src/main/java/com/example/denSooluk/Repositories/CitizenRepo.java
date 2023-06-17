package com.example.denSooluk.Repositories;

import com.example.denSooluk.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepo extends JpaRepository<Citizen, Long> {
    Citizen findCitizenByPersonalId(Long personalId);
}
