package com.project.hospital.ApiEspecialidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.hospital.ApiEspecialidad.entity.Especialidad;
import com.project.hospital.ApiEspecialidad.service.EspecialidadService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Especialidad>> findAll() {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/findByIdEspecialidad/{idEspecialidad}")
    public ResponseEntity<Especialidad> findByIdEspecialidad(
            @PathVariable int idEspecialidad) {
        return new ResponseEntity<>(service.find(idEspecialidad), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Especialidad> add(@Valid @RequestBody Especialidad especialidad) {
        return new ResponseEntity<>(service.save(especialidad), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Especialidad> edit(@PathVariable int id, @RequestBody Especialidad especialidad) {

        return new ResponseEntity<>(service.update(id, especialidad), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
