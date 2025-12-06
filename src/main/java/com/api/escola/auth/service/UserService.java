package com.api.escola.auth.service;

import com.api.escola.auth.model.User;
import com.api.escola.auth.repository.UserRepository;
import com.api.escola.auth.util.InfoUser;
import com.api.escola.auth.util.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public InfoUser cadastrarUser(User user) {
        try {
            userRepository
                .findByEmail(user.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            return new InfoUser(false, true, "Email já cadastrado!");
        }
        catch(UsernameNotFoundException e) {
            System.out.println(">>>>>>>>>>>>> user.getSenha() = " + user.getSenha());
            user.setSenha(passwordEncoder.encode(user.getSenha()));
            user.setRole(Role.USER);
            userRepository.save(user);
            return new InfoUser(true, false, "Usuário cadastrado com sucesso!");
        }
    }

    public List<User> recuperarUsers() {
        return userRepository.findAll();
    }
}