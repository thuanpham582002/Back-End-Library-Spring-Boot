package dev.noroom.thuvien.service.impl;


import dev.noroom.thuvien.model.User;
import dev.noroom.thuvien.repository.UserRepository;
import dev.noroom.thuvien.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }
}
