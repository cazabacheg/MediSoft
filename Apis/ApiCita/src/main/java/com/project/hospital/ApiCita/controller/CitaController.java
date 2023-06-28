package com.project.hospital.ApiCita.controller;

import com.project.hospital.ApiCita.dto.CitaDto;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.hospital.ApiCita.entity.Cita;
import com.project.hospital.ApiCita.service.CitaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cita")
public class CitaController {

    @Autowired
    private CitaService service;

    @GetMapping("/findCitasByDate")
    public ResponseEntity<List<CitaDto>> findCitasByDate(
            @RequestParam (required = false) @DateTimeFormat(pattern="dd-mm-yyyy") Date fechaInicio,
            @RequestParam (required = false)  @DateTimeFormat(pattern="dd-mm-yyyy") Date fechaFin) 
    {
        return new ResponseEntity<>(service.list(fechaInicio, fechaFin), HttpStatus.OK);
    }

    @GetMapping("/findCitasByUserId/{id}")
    public ResponseEntity<List<CitaDto>> findCitasByUserId(@PathVariable int id) {
        return new ResponseEntity<>(service.listByUsuario(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cita> add(@Valid @RequestBody Cita cita) {
        return new ResponseEntity<>(service.save(cita), HttpStatus.CREATED);
    }
}
