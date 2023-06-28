package com.project.hospital.ApiEspecialidad.service;

import com.project.hospital.ApiEspecialidad.entity.Especialidad;
import java.util.List;

public interface IEspecialidadService {

    public List<Especialidad> list();
    public Especialidad save(Especialidad especialidad);
    public Especialidad find(int id);
    public boolean delete(int id);
    public Especialidad update(int id, Especialidad especialidad);
}
