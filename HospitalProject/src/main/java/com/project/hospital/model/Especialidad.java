package com.project.hospital.model;

import lombok.Data;

@Data
public class Especialidad {

    private long id;
    private String nombre;
    private double precio;

    @Override
    public String toString() {
        return nombre + ", $" + precio;
    }
}
