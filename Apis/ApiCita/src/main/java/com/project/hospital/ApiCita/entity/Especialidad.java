package com.project.hospital.ApiCita.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Especialidad {

    @Positive
    private int id;
    @NotEmpty
    private String nombre;
    @Positive
    private double precio;

    @Override
    public String toString() {
        return nombre + ", $" + precio;
    }

}
