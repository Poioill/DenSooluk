package com.example.denSooluk.Services;


import com.example.denSooluk.Entity.Role;
import com.example.denSooluk.Entity.User;
import com.example.denSooluk.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String pid = user.getPersonalId();
        if (userRepo.findByPersonalId(pid) != null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ADMIN);
        log.info("Saving new User with pid: {}", pid);
        userRepo.save(user);
        return true;
    }

    public List<User> list() {
        return userRepo.findAll();
    }

    public User findUserByPersonalId(String personalId){
        return userRepo.findByPersonalId(personalId);
    }

    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }
}
