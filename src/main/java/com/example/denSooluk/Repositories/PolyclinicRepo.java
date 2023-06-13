package com.example.denSooluk.Repositories;

import com.example.denSooluk.Entity.polyclinicModels.Polyclinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolyclinicRepo extends JpaRepository<Polyclinic, Long> {
}
