package com.desarrollo.luis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.luis.model.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsuario(String usuario);
}
