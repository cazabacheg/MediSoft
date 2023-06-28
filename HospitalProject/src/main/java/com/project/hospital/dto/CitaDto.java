package com.project.hospital.dto;

import lombok.Data;
import com.project.hospital.model.Usuario;
import com.project.hospital.model.Especialidad;
import java.util.Date;

@Data
public class CitaDto {

    private long id;
    private Date fecha;
    private String hora;
    private String descripcion;
    private Usuario usuario;
    private Especialidad especialidad;
}
