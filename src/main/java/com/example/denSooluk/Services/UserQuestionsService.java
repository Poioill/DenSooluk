package com.example.denSooluk.Services;


import com.example.denSooluk.Entity.UserQuestions;
import com.example.denSooluk.Repositories.UserQuestionsRepo;
import com.example.denSooluk.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserQuestionsService {
    private final UserQuestionsRepo userQuestionsRepo;
    private final UserRepo userRepo;

    public void makeQuestions(UserQuestions userQuestions){
        userQuestions.setQuestion(userQuestions.getQuestion());
        log.info("Saving new UserQuestions. Question: {}", userQuestions.getQuestion());
        userQuestionsRepo.save(userQuestions);
    }

    public List<UserQuestions> allUserQuestions(){
        return userQuestionsRepo.findAll();
    }
}
