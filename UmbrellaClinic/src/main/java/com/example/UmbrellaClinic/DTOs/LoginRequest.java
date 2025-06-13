package com.example.UmbrellaClinic.DTOs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {
    private String correo;
    private String password;

}
