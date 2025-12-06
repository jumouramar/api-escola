package com.api.escola.auth.controller;

import com.api.escola.auth.model.User;
import com.api.escola.auth.service.UserService;
import com.api.escola.auth.util.InfoUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("usuarios")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> recuperaUser() {
        return userService.recuperarUsers();
    }

    @PostMapping
    public InfoUser cadastrarUser(@RequestBody @Valid User user) {
        return userService.cadastrarUser(user);
    }
}