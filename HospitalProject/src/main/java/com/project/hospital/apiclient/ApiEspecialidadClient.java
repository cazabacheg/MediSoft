package com.project.hospital.apiclient;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.hospital.model.Especialidad;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@FeignClient(name = "APIESPECIALIDAD")
@RefreshScope

public interface ApiEspecialidadClient{
    
    @GetMapping("/api/especialidad/findAll")
    List<Especialidad> findAll();

    @GetMapping("/api/especialidad/findByIdEspecialidad/{idEspecialidad}")
    Especialidad findByIdEspecialidad(@PathVariable String idEspecialidad);
    
    @PostMapping("/api/especialidad/add")
    Especialidad add(@RequestBody Especialidad especialidad);

    @PutMapping("/api/especialidad/edit/{id}")
    public Especialidad edit(@PathVariable int id, @RequestBody Especialidad especialidad);
    
    @DeleteMapping("/api/especialidad/delete/{id}")
    public void delete(@PathVariable int id);
}