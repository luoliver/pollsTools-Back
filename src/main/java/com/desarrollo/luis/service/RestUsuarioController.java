package com.desarrollo.luis.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.IUsuarioService;
import com.desarrollo.luis.dto.UsuarioDTO;

@RestController
@RequestMapping("/Usuarios")
public class RestUsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping
	public List<UsuarioDTO> listarUsuarios(){
		return usuarioService.consultarUsuarios();
	}
	
	@PostMapping
	public void crearUsuario(@RequestBody UsuarioDTO usuario) {
		usuario.setContrasena(encoder.encode(usuario.getContrasena()));
		usuarioService.crearUsuario(usuario);
	}
	
	@PutMapping
	public void modificar(@RequestBody UsuarioDTO usuario) {
		usuarioService.modificarUsuario(usuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathParam("id") Integer id) {
		usuarioService.eliminarUsuario(id);
	}
}
