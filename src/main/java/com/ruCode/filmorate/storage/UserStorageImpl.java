package com.ruCode.filmorate.storage;

import com.ruCode.filmorate.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserStorageImpl implements UserStorage{
    private final Map<Long,User> users = new HashMap<>();

    @Override
    public User addUser(User user) {
        users.put(user.getId(),user);
        return user;
    }

    @Override
    public User getUser(long id) {
        return users.get(id);
    }

    @Override
    public List<User> getUsers() {
        return List.copyOf(users.values());
    }

    @Override
    public void deleteUser(long id) {
        users.remove(id);
    }

    @Override
    public User updateUser(User user) {
        return users.put(user.getId(), user);
    }


}
