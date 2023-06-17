package com.example.denSooluk.Services;


import com.example.denSooluk.Entity.UserModels.UserNotes;
import com.example.denSooluk.Repositories.UserNotesRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserNotesService {
    private final UserNotesRepo userNotesRepo;

    public void makeNotes(UserNotes userNotes){
        userNotes.setTitle(userNotes.getTitle());
        userNotes.setDescription(userNotes.getDescription());
        log.info("Saving new UserNotes. Title: {}", userNotes.getTitle());
        userNotesRepo.save(userNotes);
    }

    public List<UserNotes> allUserNotes(){
        return userNotesRepo.findAll();
    }
}
