package com.ruCode.filmorate.service;

import com.ruCode.filmorate.exception.NotFound;
import com.ruCode.filmorate.model.User;
import com.ruCode.filmorate.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class InMemoryUserService implements UserService{

    private final UserStorage userStorage;
    private static Long id = 1L;

    @Override
    public User addUser(User user) {
        user.setId(id++);
        setName(user);
        log.debug("Add user");
        return userStorage.addUser(user);
    }

    @Override
    public User getUser(long id) {
        User user = userStorage.getUser(id);
        if(user == null){
            throw new NotFound("User не найден");
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userStorage.getUsers();
    }

    @Override
    public void deleteUser(long id) {
        log.debug("Delete user");
        getUser(id);
        userStorage.deleteUser(id);
    }

    @Override
    public User updateUser(User user) {
        log.debug("Update user");
        User oldUser = getUser(user.getId());
        User newUser = update(oldUser,user);
        userStorage.updateUser(newUser);
        return newUser;
    }

    @Override
    public void addFriend(long id, long friendId) {
        User friend = getUser(friendId);
        User user = getUser(id);
        user.addFriend(friendId);
        friend.addFriend(id);
        updateUser(friend);
        updateUser(user);
    }

    @Override
    public void deleteFriend(long id, long friendId) {
        User friend = getUser(friendId);
        User user = getUser(id);
        boolean isFriend = user.deleteFriend(friendId);
        friend.deleteFriend(id);
        if(!isFriend){
            throw new NotFound("Это не твой друг");
        }

    }

    @Override
    public List<User> getFriends(long id) {
        User user = getUser(id);
        return getUsersFromIds(user.getFriends());
    }

    @Override
    public List<User> getCommonFriends(long id, long otherId) {
        User user = getUser(id);
        User otherUser = getUser(otherId);
        Set<Long> friendsOther = otherUser.getFriends();
        List<User> users = new ArrayList<>();
        for(Long userId: user.getFriends()){
            if(friendsOther.contains(userId)){
                users.add(getUser(userId));
            }
        }
        return users;
    }


    private void setName(User user){
        if(user.getName() == null){
            user.setName(user.getLogin());
        }
    }
    private User update(User oldUser, User user){
        if(user.getName()!=null){
            oldUser.setName(user.getName());
        }
        if(user.getLogin() != null){
            oldUser.setLogin(user.getLogin());
        }
        if(user.getEmail()!=null){
            oldUser.setEmail(user.getEmail());
        }
        if(user.getBirthday()!=null){
            oldUser.setBirthday(user.getBirthday());
        }
        if(user.getFriends()!=null){
            oldUser.setFriends(user.getFriends());
        }
        return oldUser;
    }
    private List<User> getUsersFromIds(Set<Long> ids){
        List<User> users = new ArrayList<>();
        for(Long id: ids){
            users.add(getUser(id));
        }
        return users;
    }
}
