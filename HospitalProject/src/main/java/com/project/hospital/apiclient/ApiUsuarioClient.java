package com.project.hospital.apiclient;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.hospital.model.Usuario;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@Configuration
@FeignClient(name = "APIUSUARIO")
@RefreshScope

public interface ApiUsuarioClient {
    
    @GetMapping("/api/usuario/findAll")
    List<Usuario> findAll();
    
    @GetMapping("/api/usuario/findByIdUsuario/{idUsuario}")
    Usuario findByIdUsuario(@PathVariable String idUsuario);
    
    @PostMapping("/api/usuario/add")
    Usuario add(@RequestBody Usuario usuario);
    
    @PostMapping("/api/usuario/createDefault")
    Usuario createDefault();
    
    @PostMapping("/api/usuario/login")
    Usuario login(@RequestParam String username, @RequestParam String password);
    
    @PutMapping("/api/usuario/edit/{id}")
    Usuario edit(@PathVariable int id, @RequestBody Usuario usuario);
    
    @DeleteMapping("/api/usuario/delete/{id}")
    public void delete(@PathVariable int id);
}
