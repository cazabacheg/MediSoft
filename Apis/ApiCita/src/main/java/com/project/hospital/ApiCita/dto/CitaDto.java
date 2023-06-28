package com.project.hospital.ApiCita.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.project.hospital.ApiCita.entity.Usuario;
import com.project.hospital.ApiCita.entity.Especialidad;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CitaDto {

    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private String hora;
    private String descripcion;
    @NotNull
    private Usuario usuario;
    @NotNull
    private Especialidad especialidad;
}
