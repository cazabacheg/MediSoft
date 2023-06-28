package com.project.hospital.ApiUsuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
        @NotEmpty
	private String username;
        @NotEmpty
	private String password;
        @NotEmpty
	private String nombres;
        @NotEmpty
	private String apellidos;
        @NotEmpty
	private String rol;

	@Override
	public String toString() {
		return nombres + " " + apellidos;
	}

}
