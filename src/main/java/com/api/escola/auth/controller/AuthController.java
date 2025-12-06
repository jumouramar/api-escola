package com.api.escola.auth.controller;

import com.api.escola.auth.model.User;
import com.api.escola.auth.repository.UserRepository;
import com.api.escola.auth.service.JwtService;
import com.api.escola.auth.util.TokenResponse;
import com.api.escola.auth.util.UserLogin;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
@RestController
@RequestMapping("autenticacao")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody UserLogin userLogin,
                                               HttpServletResponse response) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getSenha()));

        User user = userRepository.findByEmail(userLogin.getEmail()).orElseThrow();

        String accessToken = jwtService.generateAccessToken(user);

        return new ResponseEntity<>(new TokenResponse(
            accessToken, user.getId(), user.getNome(), user.getRole().name()), HttpStatus.OK);
    }
}