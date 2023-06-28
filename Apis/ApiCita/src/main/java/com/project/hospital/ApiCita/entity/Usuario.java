package com.project.hospital.ApiCita.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Usuario {

    @Positive
    private int id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String rol;

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }

}
