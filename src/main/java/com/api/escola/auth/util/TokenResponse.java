package com.api.escola.auth.util;

public record TokenResponse(String token, long idUser, String nome, String role) {}