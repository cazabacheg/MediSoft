package com.project.hospital.ApiUsuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.hospital.ApiUsuario.entity.Usuario;
import com.project.hospital.ApiUsuario.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Usuario>> findAll() {
        return new ResponseEntity<>(
                service.list(), HttpStatus.OK);
    }

    @GetMapping("/findByIdUsuario/{idUsuario}")
    public ResponseEntity<Usuario> findByIdUsuario(
            @PathVariable int idUsuario) {
        return new ResponseEntity<>(
                service.find(idUsuario), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> add(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(service.save(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/createDefault")
    public ResponseEntity<Usuario> createDefault() {
        return new ResponseEntity<>(service.createDefault(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String username, @RequestParam String password) {
        return new ResponseEntity<>(service.login(username, password), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Usuario> edit(@PathVariable int id, @RequestBody Usuario usuario) {

        return new ResponseEntity<>(service.update(id, usuario), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
