package com.desarrollo.luis.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.IRolService;
import com.desarrollo.luis.dto.RolDTO;
import com.desarrollo.luis.model.Rol;

@RestController
@RequestMapping("/Roles")
public class restController {

	@Autowired
	private IRolService rolService;
	
	@GetMapping
	public List<RolDTO> listar(){
		return rolService.findRoles();
	}
	
	@PostMapping
	public void guardar(@RequestBody Rol rol) {
		
	}
	
	@PutMapping
	public void modificar(@RequestBody Rol rol) {
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathParam("id") Integer id) {
	}
}
