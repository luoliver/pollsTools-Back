package com.desarrollo.luis.service;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.IUsuarioService;
import com.desarrollo.luis.dto.UsuarioDTO;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class RestUsuarioController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestUsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<UsuarioDTO> listarUsuarios(){
		return usuarioService.consultarUsuarios();
	}

	@PostMapping
	public ResponseEntity<?> crearUsuario(@Valid @RequestBody UsuarioDTO usuario) {
		try {
			usuario.setContrasena(encoder.encode(usuario.getContrasena()));
			usuarioService.crearUsuario(usuario);
			return ResponseEntity.ok(true);
		}catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
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
