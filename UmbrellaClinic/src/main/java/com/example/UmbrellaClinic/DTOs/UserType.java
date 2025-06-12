package com.example.UmbrellaClinic.DTOs;

public enum UserType {
    PACIENTE(1),
    ENFERMERO(2),
    MEDICO(3),
    QUIMICO_FARMACEUTICO(4),
    GERENTE(5),
    SECRETARIO(6),
    SOPORTE_TECNICO(7);

    private final int code;
    UserType(int code) { this.code = code; }
    public int getCode() { return code; }

    public static UserType fromCode(int code) {
        for (UserType t : values()) {
            if (t.code == code) return t;
        }
        throw new IllegalArgumentException("Código inválido: " + code);
    }
}
