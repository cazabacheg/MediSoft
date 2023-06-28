package com.project.hospital.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hospital.apiclient.ApiEspecialidadClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.hospital.model.Especialidad;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EspecialidadService {

    @Autowired
    private ApiEspecialidadClient apiEspecialidadClient;

    private final Logger log = LoggerFactory.getLogger(EspecialidadService.class);

    public List<Especialidad> list() {
        var listesp = apiEspecialidadClient.findAll();
        try {
            log.info(EspecialidadService.class.getName() + " ApiEspecialidadClient list() result : {}", new ObjectMapper().writeValueAsString(listesp));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(EspecialidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listesp;
    }

    public Especialidad save(Especialidad especialidad) {
        var espc = apiEspecialidadClient.add(especialidad);
        try {
            log.info(EspecialidadService.class.getName() + " ApiEspecialidadClient add() especialidad: {}, result : {}", new ObjectMapper().writeValueAsString(especialidad), new ObjectMapper().writeValueAsString(espc));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(EspecialidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espc;
    }

    public Especialidad find(int id) {
        var espc = apiEspecialidadClient.findByIdEspecialidad(String.valueOf(id));
        try {
            log.info(EspecialidadService.class.getName() + " ApiEspecialidadClient find() id: {}, result : {}", id, new ObjectMapper().writeValueAsString(espc));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(EspecialidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espc;
    }

    public boolean delete(int id) {
        apiEspecialidadClient.delete(id);
        log.info(EspecialidadService.class.getName() + " ApiEspecialidadClient delete() id : {}", id);
        return true;
    }
}
