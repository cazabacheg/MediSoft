package com.project.hospital.ApiCita.apiclient;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.hospital.ApiCita.entity.Usuario;
@Configuration
@FeignClient(name = "APIUSUARIO")
@RefreshScope

public interface ApiUsuarioClient {
    
    @GetMapping("/api/usuario/findByIdUsuario/{idUsuario}")
    Usuario findByIdUsuario(@PathVariable String idUsuario);
    
}
