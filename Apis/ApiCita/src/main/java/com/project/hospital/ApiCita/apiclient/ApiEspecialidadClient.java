package com.project.hospital.ApiCita.apiclient;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.hospital.ApiCita.entity.Especialidad;

@Configuration
@FeignClient(name = "APIESPECIALIDAD")
@RefreshScope

public interface ApiEspecialidadClient{

    @GetMapping("/api/especialidad/findByIdEspecialidad/{idEspecialidad}")
    Especialidad findByIdEspecialidad(@PathVariable String idEspecialidad);

}