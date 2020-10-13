package com.desarrollo.luis.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.IRolService;
import com.desarrollo.luis.converters.RolConverter;
import com.desarrollo.luis.dto.RolDTO;
import com.desarrollo.luis.model.Rol;
import com.desarrollo.luis.repository.IRolDao;

@Service
public class RolService implements IRolService{

	@Autowired
	private IRolDao rol;

	@Override
	public List<RolDTO> findRoles() {
		List<Rol> listaResultado = rol.findAll();
		return RolConverter.converterModeloADtoSimple(listaResultado);
	}

	@Override
	public RolDTO findRolByNombre(String nombreRol) {
		Rol resultado = rol.findByNombre(nombreRol);
		return RolConverter.converterModeloADtoCompleto(resultado);
	}
	
}
