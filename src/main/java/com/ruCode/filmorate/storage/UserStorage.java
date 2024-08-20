package com.ruCode.filmorate.storage;

import com.ruCode.filmorate.model.User;

import java.util.List;

public interface UserStorage {
    User addUser(User user);
    User getUser(long id);
    List<User> getUsers();
    void deleteUser(long id);
    User updateUser(User user);
}
