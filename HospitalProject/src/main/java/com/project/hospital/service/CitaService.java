package com.project.hospital.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hospital.apiclient.ApiCitaClient;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.hospital.model.Cita;
import com.project.hospital.dto.CitaDto;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CitaService {

    @Autowired
    private ApiCitaClient apiCitaClient;

    private final Logger log = LoggerFactory.getLogger(CitaService.class);

    public Cita save(Cita cita) {
        var ct = apiCitaClient.add(cita);
        try {
            log.info(CitaService.class.getName() + " ApiCitaClient add() cita: {}, result : {}", new ObjectMapper().writeValueAsString(cita), new ObjectMapper().writeValueAsString(ct));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct;
    }

    public List<CitaDto> listByUsuario(int usuario_id) {
        var listct = apiCitaClient.findCitasByUserId(usuario_id);
        try {
            log.info(CitaService.class.getName() + " ApiCitaClient listByUsuario() usuario_id: {}, result : {}", usuario_id, new ObjectMapper().writeValueAsString(listct));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listct;
    }

    public List<CitaDto> list(Date fecha_inicio, Date fecha_fin) {
        var listctd = apiCitaClient.findCitasByDate(fecha_inicio, fecha_fin);
        try {
            log.info(CitaService.class.getName() + " ApiCitaClient list() fecha_inicio: {}, fecha_fin: {}, result : {}", fecha_inicio, fecha_fin, new ObjectMapper().writeValueAsString(listctd));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listctd;
    }
}
