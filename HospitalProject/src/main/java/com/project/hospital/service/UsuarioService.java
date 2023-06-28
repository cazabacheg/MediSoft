package com.project.hospital.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hospital.apiclient.ApiUsuarioClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.hospital.model.Usuario;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService {

    @Autowired
    private ApiUsuarioClient apiUsuarioClient;

    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    public Usuario save(Usuario usuario) {
        var usu = apiUsuarioClient.add(usuario);
        try {
            log.info(UsuarioService.class.getName() + " ApiUsuarioClient add() usuario: {}, result : {}", new ObjectMapper().writeValueAsString(usuario), new ObjectMapper().writeValueAsString(usu));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }

    public Usuario find(int id) {
        var usu = apiUsuarioClient.findByIdUsuario(String.valueOf(id));
        try {
            log.info(UsuarioService.class.getName() + " ApiUsuarioClient find() id: {}, result : {}", id, new ObjectMapper().writeValueAsString(usu));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }

    public boolean delete(int id) {
        apiUsuarioClient.delete(id);
        log.info(UsuarioService.class.getName() + " ApiUsuarioClient delete() id: {}", id);
        return true;
    }

    public Usuario login(String username, String password) {
        var reslogin = apiUsuarioClient.login(username, password);
        log.info(UsuarioService.class.getName() + " ApiUsuarioClient login() username: {}", username);
        return reslogin;
    }

    public List<Usuario> list() {
        var listusu = apiUsuarioClient.findAll();
        try {
            log.info(UsuarioService.class.getName() + " ApiUsuarioClient list() result : {}", new ObjectMapper().writeValueAsString(listusu));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listusu;
    }

    public Usuario createDefault() {
        log.info(UsuarioService.class.getName() + " ApiUsuarioClient createDefault() Creando usuario default");
        return apiUsuarioClient.createDefault();
    }
}
