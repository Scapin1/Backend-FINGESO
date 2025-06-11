package com.example.UmbrellaClinic.DTOs;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class LoginRequest {
    private String correo;
    private String password;


    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
