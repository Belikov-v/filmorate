package com.ruCode.filmorate.controller;


import com.ruCode.filmorate.model.User;
import com.ruCode.filmorate.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PutMapping()
    public User updateUser(@RequestBody @Valid User user){
        return userService.updateUser(user);
    }

    @PostMapping()
    public User postUser(@RequestBody @Valid User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}/friends/{friendId}")
    public void addFriend(@PathVariable long id, @PathVariable long friendId){
        userService.addFriend(id,friendId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public void deleteFriend(@PathVariable long id, @PathVariable long friendId){
        userService.addFriend(id,friendId);
    }

    @GetMapping("/{id}/friends")
    public void getFriends(@PathVariable long id){
        userService.getFriends(id);
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public List<User> getCommonFriends(@PathVariable long id, @PathVariable long otherId){
        return userService.getCommonFriends(id, otherId);
    }
}
