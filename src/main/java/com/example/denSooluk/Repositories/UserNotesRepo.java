package com.example.denSooluk.Repositories;

import com.example.denSooluk.Entity.UserModels.UserNotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotesRepo extends JpaRepository<UserNotes, Long> {
}
