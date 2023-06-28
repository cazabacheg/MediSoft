package com.project.hospital.ApiUsuario.service;

import com.project.hospital.ApiUsuario.entity.Usuario;
import java.util.List;

public interface IUsuarioService {

    public Usuario save(Usuario usuario);
    public Usuario find(int id);
    public boolean delete(int id);
    public Usuario login(String username, String password);
    public List<Usuario> list();
    public Usuario createDefault();
    public Usuario update(int id, Usuario usuario);
}
