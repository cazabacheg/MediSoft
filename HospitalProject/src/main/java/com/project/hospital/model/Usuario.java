package com.project.hospital.model;

import lombok.Data;

@Data
public class Usuario {

    private int id;
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private String rol;

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
}
