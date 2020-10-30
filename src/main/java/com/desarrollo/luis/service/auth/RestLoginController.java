package com.desarrollo.luis.service.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.IUsuarioService;
import com.desarrollo.luis.dto.UrlMenuDTO;
import com.desarrollo.luis.dto.UsuarioDTO;
import com.desarrollo.luis.enums.EnumUrl;
import com.desarrollo.luis.enums.EnumUrlRol;
import com.desarrollo.luis.security.JwtService;
import com.desarrollo.luis.security.UserDetailsImpl;
import com.desarrollo.luis.service.request.AuthenticationRequest;
import com.desarrollo.luis.service.request.ValidationUrlTokenRequest;
import com.desarrollo.luis.service.response.AuthenticationResponse;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class RestLoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping
	public List<UsuarioDTO> listarUsuarios(){
		return usuarioService.consultarUsuarios();
	}

	/**
	 * 
	 * @param authenticationRequest
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<?> createToken(@Valid @RequestBody AuthenticationRequest authenticationRequest) {

		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsuario(), authenticationRequest.getContrasena()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtService.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			EnumUrlRol enumUrlRol = EnumUrlRol.consultarEnumUrlRolPorRol(roles.iterator().next());
			List<UrlMenuDTO> listaMenus = new ArrayList<>();
			for(EnumUrl enumUrl :enumUrlRol.getListaUrls()) {
				listaMenus.add(new UrlMenuDTO(enumUrl));				
			}
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt, 
					userDetails.getId(), 
					userDetails.getUsername(), 
					listaMenus));
		}catch (Exception excepcion) {
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * 
	 */
	@PostMapping("/validateUrl")
	public ResponseEntity<?> validateTokenURl(@Valid @RequestBody ValidationUrlTokenRequest validationUrlTokenRequest) {
		try {
			Boolean permiso = true;
			return ResponseEntity.ok(permiso);
		}catch (Exception excepcion) {
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
