package com.project.hospital.ApiUsuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital.ApiUsuario.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	public Usuario findByUsername(String username);
}
