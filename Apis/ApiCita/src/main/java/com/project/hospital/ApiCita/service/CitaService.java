package com.project.hospital.ApiCita.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hospital.ApiCita.apiclient.ApiUsuarioClient;
import com.project.hospital.ApiCita.apiclient.ApiEspecialidadClient;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.hospital.ApiCita.entity.Cita;
import com.project.hospital.ApiCita.dao.ICitaRepository;
import com.project.hospital.ApiCita.dto.CitaDto;
import com.project.hospital.ApiCita.entity.Especialidad;
import com.project.hospital.ApiCita.entity.Usuario;
import java.util.LinkedList;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CitaService implements ICitaService {

    @Autowired
    private ICitaRepository repository;
    
    @Autowired
    private ApiUsuarioClient apiUsuarioClient;
    
    @Autowired
    private ApiEspecialidadClient apiEspecialidadClient;
    
    private final Logger log = LoggerFactory.getLogger(CitaService.class);

    @Override
    public Cita save(Cita cita) {
        var ct = repository.save(cita);
        try {
            log.info(CitaService.class.getName() + " save() cita: {}, result : {}", new ObjectMapper().writeValueAsString(cita), new ObjectMapper().writeValueAsString(ct));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CitaDto> listByUsuario(int usuario_id) {
        var listacitas = repository.listByUsuario(usuario_id);
        List<CitaDto> listCitaDTO = new LinkedList<>();

        listacitas.forEach(ct -> {
            CitaDto ctdto = new CitaDto();
            Usuario user = apiUsuarioClient.findByIdUsuario(String.valueOf(ct.getUsuario_id()));
            Especialidad espec = apiEspecialidadClient.findByIdEspecialidad(String.valueOf(ct.getEspecialidad_id()));

            ctdto.setId(ct.getId());
            ctdto.setFecha(ct.getFecha());
            ctdto.setHora(ct.getHora());
            ctdto.setDescripcion(ct.getDescripcion());
            ctdto.setUsuario(user);
            ctdto.setEspecialidad(espec);

            listCitaDTO.add(ctdto);
        });
        try {
            log.info(CitaService.class.getName() + " listByUsuario() usuario_id: {}, result : {}", usuario_id, new ObjectMapper().writeValueAsString(listCitaDTO));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCitaDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CitaDto> list(Date fecha_inicio, Date fecha_fin) {
        
        List<Cita> listacitas;
        if (fecha_inicio != null && fecha_fin != null) {
            listacitas = repository.listByDateOrdered(fecha_inicio, fecha_fin);
        } else {
            listacitas = repository.listOrdered();
        }

        List<CitaDto> listCitaDTO = new LinkedList<>();

        listacitas.forEach(ct -> {
            CitaDto ctdto = new CitaDto();
            Usuario user = apiUsuarioClient.findByIdUsuario(String.valueOf(ct.getUsuario_id()));
            Especialidad espec = apiEspecialidadClient.findByIdEspecialidad(String.valueOf(ct.getEspecialidad_id()));

            ctdto.setId(ct.getId());
            ctdto.setFecha(ct.getFecha());
            ctdto.setHora(ct.getHora());
            ctdto.setDescripcion(ct.getDescripcion());
            ctdto.setUsuario(user);
            ctdto.setEspecialidad(espec);

            listCitaDTO.add(ctdto);
        });
        try {
            log.info(CitaService.class.getName() + " listByUsuario() fecha_inicio: {}, fecha_fin : {}, result : {}", fecha_inicio, fecha_fin, new ObjectMapper().writeValueAsString(listCitaDTO));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(CitaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCitaDTO;
    }

}
