package com.example.denSooluk.Services;


import com.example.denSooluk.Entity.User;
import com.example.denSooluk.Entity.UserModels.UserNotes;
import com.example.denSooluk.Repositories.UserNotesRepo;
import com.example.denSooluk.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserNotesService {
    private final UserNotesRepo userNotesRepo;
    private final UserRepo userRepo;

    public void makeNotes(Principal principal, UserNotes userNotes){
        userNotes.setUser(getUserByPrincipal(principal));
        userNotes.setTitle(userNotes.getTitle());
        userNotes.setDescription(userNotes.getDescription());
        log.info("Saving new UserNotes. Title: {}", userNotes.getTitle());
        userNotesRepo.save(userNotes);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepo.findByPersonalId(principal.getName());
    }

    public List<UserNotes> allUserNotes(){
        return userNotesRepo.findAll();
    }
}
