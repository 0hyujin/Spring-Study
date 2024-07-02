package com.example.jwt.security;

import com.example.jwt.domain.User;
import com.example.jwt.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserId(username).orElseThrow(RuntimeException::new);

        return org.springframework.security.core.userdetails.User
            .withUsername(username)
            .password(user.getPassword())
            .authorities(String.valueOf(user.getUserRoles()))
            .build();
    }
}
