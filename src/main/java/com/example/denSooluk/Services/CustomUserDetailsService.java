package com.example.denSooluk.Services;

import com.example.denSooluk.Entity.User;
import com.example.denSooluk.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByPersonalId(username);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return user;
    }
}
