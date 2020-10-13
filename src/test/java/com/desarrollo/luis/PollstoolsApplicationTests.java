package com.desarrollo.luis;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.desarrollo.luis.controller.IUsuarioService;
import com.desarrollo.luis.dto.UsuarioDTO;

@SpringBootTest
class PollstoolsApplicationTests {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void contextLoads() {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setContrasena(encoder.encode("12345678"));
		usuario.setId(2);
		usuario.setUsuario("Admin1");
		UsuarioDTO retornado = usuarioService.crearUsuario(usuario);
		assertTrue(retornado.getContrasena().equalsIgnoreCase(usuario.getContrasena()));
	}

}
