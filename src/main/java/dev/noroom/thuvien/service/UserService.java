package dev.noroom.thuvien.service;

import dev.noroom.thuvien.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);
}
