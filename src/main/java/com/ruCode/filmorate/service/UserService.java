package com.ruCode.filmorate.service;

import com.ruCode.filmorate.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUser(long id);
    List<User> getUsers();
    void deleteUser(long id);
    User updateUser(User user);
    void addFriend(long id, long friendId);
    void deleteFriend(long id, long friendId);
    List<User> getFriends(long id);
    List<User> getCommonFriends(long id, long otherId);
}
