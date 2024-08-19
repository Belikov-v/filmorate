package com.ruCode.filmorate.controller;


import com.ruCode.filmorate.model.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private static Long id = 1L;
    private final Map<Long, User> users = new HashMap<>();

    @GetMapping()
    public List<User> getUsers(){
        return List.copyOf(users.values());
    }

    @PostMapping
    public User postUser(@RequestBody @Valid User user){
        log.debug("POST user");
        user.setId(id++);
        setName(user);
        users.put(user.getId(), user);
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody @Valid User user){
        log.debug("Put user");
        users.put(user.getId(), user);
        return user;
    }

    private void setName(User user){
        if(user.getName() == null){
            user.setName(user.getLogin());
        }
    }
}
