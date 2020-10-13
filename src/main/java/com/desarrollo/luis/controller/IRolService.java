package com.desarrollo.luis.controller;

import java.util.List;

import com.desarrollo.luis.dto.RolDTO;

/**
 * Interfaz de la capa de negocio que maneja los metodos de los roles
 * 
 * @author
 */
public interface IRolService {
 
	public List<RolDTO> findRoles();
	
	public RolDTO findRolByNombre(String nombreRol);
}
