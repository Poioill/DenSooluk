package com.example.denSooluk.Repositories;

import com.example.denSooluk.Entity.mainPage.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
}
