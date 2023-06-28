package com.project.hospital.ApiUsuario.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.hospital.ApiUsuario.entity.Usuario;
import com.project.hospital.ApiUsuario.dao.IUsuarioRepository;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Override
    public Usuario save(Usuario usuario) {
        var usu = repository.save(usuario);
        try {
            log.info(UsuarioService.class.getName() + " save() usuario: {}, result : {}", new ObjectMapper().writeValueAsString(usuario), new ObjectMapper().writeValueAsString(usu));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario find(int id) {
        Optional<Usuario> usuario = repository.findById(id);
        try {
            log.info(UsuarioService.class.getName() + " find() id : {}, result: {}", id, new ObjectMapper().writeValueAsString(usuario.isEmpty() ? usuario : usuario.get()));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return !usuario.isEmpty() ? usuario.get() : null;
    }

    @Override
    public boolean delete(int id) {
        Usuario usuario = find(id);
        if (usuario != null) {
            repository.delete(usuario);
            log.info(UsuarioService.class.getName() + " delete() id : {}", id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario login(String username, String password) {
        if (password.trim().isEmpty()) {
            return null;
        }
        Usuario user = repository.findByUsername(username);
        try {
            log.info(UsuarioService.class.getName() + " login() username : {}, result: {}", new ObjectMapper().writeValueAsString(username), new ObjectMapper().writeValueAsString(user));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> list() {
        var listusu = repository.findAll();
        try {
            log.info(UsuarioService.class.getName() + " list(), result: {}", new ObjectMapper().writeValueAsString(listusu));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listusu;
    }

    @Override
    public Usuario createDefault() {
        log.info(UsuarioService.class.getName() + " createDefault() Creando usuario default");
        if (!list().isEmpty()) {
            return null;
        }
        Usuario u = new Usuario();
        u.setUsername("admin");
        u.setPassword("admin");
        u.setNombres("Default");
        u.setApellidos("Default");
        u.setRol("Admin");
        return save(u);
    }

    @Override
    public Usuario update(int id, Usuario usuario) {
        try {
            log.info(UsuarioService.class.getName() + " update() id: {}, usuario: {}", id, new ObjectMapper().writeValueAsString(usuario));
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario usuarioDB = repository.findById(id).get();
        usuarioDB.setUsername(usuario.getUsername());
        usuarioDB.setPassword(usuario.getPassword());
        usuarioDB.setNombres(usuario.getNombres());
        usuarioDB.setApellidos(usuario.getApellidos());
        usuarioDB.setRol(usuario.getRol());
        return repository.save(usuarioDB);
    }
}
