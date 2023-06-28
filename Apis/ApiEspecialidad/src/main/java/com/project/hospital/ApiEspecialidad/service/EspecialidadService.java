package com.project.hospital.ApiEspecialidad.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.hospital.ApiEspecialidad.entity.Especialidad;
import com.project.hospital.ApiEspecialidad.dao.IEspecialidadRepository;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EspecialidadService implements IEspecialidadService {

    @Autowired
    private IEspecialidadRepository repository;

    private final Logger log = LoggerFactory.getLogger(EspecialidadService.class);

    @Override
    @Transactional(readOnly = true)
    public List<Especialidad> list() {
        var list = repository.findAll();
        try {
            log.info(EspecialidadService.class.getName() + " list(), result: {}", new ObjectMapper().writeValueAsString(list));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(EspecialidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        var espc = repository.save(especialidad);
        try {
            log.info(EspecialidadService.class.getName() + " save() especialidad: {}, result : {}", new ObjectMapper().writeValueAsString(especialidad), new ObjectMapper().writeValueAsString(espc));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(EspecialidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espc;
    }

    @Override
    @Transactional(readOnly = true)
    public Especialidad find(int id) {
        Optional<Especialidad> especialidad = repository.findById(id);
        try {
            log.info(EspecialidadService.class.getName() + " find() id : {}, result: {}", id, new ObjectMapper().writeValueAsString(especialidad.isEmpty() ? especialidad : especialidad.get()));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(EspecialidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return !especialidad.isEmpty() ? especialidad.get() : null;
    }

    @Override
    public boolean delete(int id) {
        Especialidad especialidad = find(id);
        if (especialidad != null) {
            repository.delete(especialidad);
            log.info(EspecialidadService.class.getName() + " delete() id : {}", id);
            return true;
        }
        return false;
    }

    @Override
    public Especialidad update(int id, Especialidad especialidad) {
        try {
            log.info(EspecialidadService.class.getName() + " update() id: {}, especialidad: {}", id, new ObjectMapper().writeValueAsString(especialidad));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(EspecialidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Especialidad especialidadDB = repository.findById(id).get();
        especialidadDB.setNombre(especialidad.getNombre());
        especialidadDB.setPrecio(especialidad.getPrecio());
        return repository.save(especialidadDB);
    }
}
