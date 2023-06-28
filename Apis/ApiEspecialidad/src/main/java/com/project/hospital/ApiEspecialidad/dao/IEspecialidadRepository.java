package com.project.hospital.ApiEspecialidad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital.ApiEspecialidad.entity.Especialidad;

public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {

}
