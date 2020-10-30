package com.desarrollo.luis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.IRolService;
import com.desarrollo.luis.dto.RolDTO;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RestRolesController {

	@Autowired
	private IRolService rolService;
	
	@GetMapping
	public List<RolDTO> listar(){
		return rolService.findRoles();
	}
	
	@GetMapping("/{nombreRol}")
	@ResponseBody
	public RolDTO consultarPorId(@PathVariable String nombreRol){
		return rolService.findRolByNombre(nombreRol);
	}
}
