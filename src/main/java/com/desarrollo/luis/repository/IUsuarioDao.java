package com.desarrollo.luis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.luis.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsuario(String usuario);

	public boolean existsByUsuario(String usuario);
}
