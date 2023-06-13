package com.example.denSooluk.Repositories;

import com.example.denSooluk.Entity.polyclinicModels.Polyclinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolyclinicRepo extends JpaRepository<Polyclinic, Long> {
    List<Polyclinic> findPolyclinicByNameContainingIgnoreCase(String name);
}
