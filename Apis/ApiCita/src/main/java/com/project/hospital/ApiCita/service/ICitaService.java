package com.project.hospital.ApiCita.service;

import com.project.hospital.ApiCita.dto.CitaDto;
import com.project.hospital.ApiCita.entity.Cita;
import java.util.Date;
import java.util.List;

public interface ICitaService {

    public Cita save(Cita cita);
    public List<CitaDto> listByUsuario(int usuario_id);
    public List<CitaDto> list(Date fecha_inicio, Date fecha_fin);
}
