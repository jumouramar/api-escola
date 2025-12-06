package com.api.escola.auth.util;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLogin {
    @NotBlank(message = "O 'email' deve ser informado")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A 'senha' deve ser informada")
    private String senha;
}
