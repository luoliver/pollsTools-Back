package com.desarrollo.luis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.luis.model.Rol;

public interface IRolDao extends JpaRepository<Rol, Integer> {

	public Rol findByNombre(String nombre);
}
