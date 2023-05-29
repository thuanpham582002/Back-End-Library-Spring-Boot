package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.model.User;
import dev.noroom.thuvien.repository.UserRepository;
import dev.noroom.thuvien.service.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User foundUser = userRepository.findByUsername(username);
//        if (foundUser == null) {
//            throw new UsernameNotFoundException("User" + username + "not found");
//        }
//        return foundUser;
//    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}