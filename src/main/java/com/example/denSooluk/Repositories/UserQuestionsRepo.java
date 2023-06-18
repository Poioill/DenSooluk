package com.example.denSooluk.Repositories;

import com.example.denSooluk.Entity.UserQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestionsRepo extends JpaRepository<UserQuestions, Long> {
}
