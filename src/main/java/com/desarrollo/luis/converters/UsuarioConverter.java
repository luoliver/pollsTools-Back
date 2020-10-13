package com.desarrollo.luis.converters;

import java.util.ArrayList;
import java.util.List;

import com.desarrollo.luis.dto.UsuarioDTO;
import com.desarrollo.luis.model.Usuario;

public class UsuarioConverter {

	public static UsuarioDTO converterModeloADtoSimple(Usuario usuarioAConvertir) {
		UsuarioDTO usuarioConvertido = new UsuarioDTO();
		usuarioConvertido.setContrasena(usuarioAConvertir.getContrasena());
		usuarioConvertido.setFechaNacimiento(usuarioAConvertir.getFechaNacimiento());
		usuarioConvertido.setGenero(usuarioAConvertir.getGenero());
		usuarioConvertido.setId(usuarioAConvertir.getId());
		usuarioConvertido.setPrimerApellido(usuarioAConvertir.getPrimerApellido());
		usuarioConvertido.setSegundoApellido(usuarioAConvertir.getSegundoApellido());
		usuarioConvertido.setPrimerNombre(usuarioAConvertir.getPrimerNombre());
		usuarioConvertido.setSegundoNombre(usuarioAConvertir.getSegundoNombre());
		usuarioConvertido.setUsuario(usuarioAConvertir.getUsuario());
		
		usuarioConvertido.setRolUsuario(RolConverter.converterModeloADtoSimple(usuarioAConvertir.getRolUsuario()));
		return usuarioConvertido;
	}

	public static Usuario converterDtoAModeloSimple(UsuarioDTO usuarioAConvertir) {
		Usuario usuarioConvertido = new Usuario();
		usuarioConvertido.setContrasena(usuarioAConvertir.getContrasena());
		usuarioConvertido.setFechaNacimiento(usuarioAConvertir.getFechaNacimiento());
		usuarioConvertido.setGenero(usuarioAConvertir.getGenero());
		usuarioConvertido.setId(usuarioAConvertir.getId());
		usuarioConvertido.setPrimerApellido(usuarioAConvertir.getPrimerApellido());
		usuarioConvertido.setSegundoApellido(usuarioAConvertir.getSegundoApellido());
		usuarioConvertido.setPrimerNombre(usuarioAConvertir.getPrimerNombre());
		usuarioConvertido.setSegundoNombre(usuarioAConvertir.getSegundoNombre());
		usuarioConvertido.setUsuario(usuarioAConvertir.getUsuario());
		
		usuarioConvertido.setRolUsuario(RolConverter.converterDtoAModeloSimple(usuarioAConvertir.getRolUsuario()));
		return usuarioConvertido;
	}

	public static List<UsuarioDTO> converterListaModeloADtoSimple(List<Usuario> listaUsuarioAConvertir) {
		List<UsuarioDTO> listaUsuariosConvertidos = new ArrayList<>();
		for(Usuario usuarioAConvertir: listaUsuarioAConvertir) {
			listaUsuariosConvertidos.add(converterModeloADtoSimple(usuarioAConvertir));
		}
		return listaUsuariosConvertidos;
	}

	public static List<Usuario> converterListaDtoAModeloSimple(List<UsuarioDTO> listaUsuarioAConvertir) {
		List<Usuario> listaUsuariosConvertidos = new ArrayList<>();
		for(UsuarioDTO usuarioAConvertir: listaUsuarioAConvertir) {
			listaUsuariosConvertidos.add(converterDtoAModeloSimple(usuarioAConvertir));
		}
		return listaUsuariosConvertidos;
	}
}
