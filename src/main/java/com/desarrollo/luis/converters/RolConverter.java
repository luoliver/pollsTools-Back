package com.desarrollo.luis.converters;

import java.util.ArrayList;
import java.util.List;

import com.desarrollo.luis.dto.RolDTO;
import com.desarrollo.luis.model.Rol;

public class RolConverter {

	public static RolDTO converterModeloADtoSimple(Rol rolAConvertir) {
		RolDTO rolConvertido = new RolDTO();
		rolConvertido.setIdRol(rolAConvertir.getIdRol());
		rolConvertido.setNombre(rolAConvertir.getNombre());
		return rolConvertido;
	}
	
	public static Rol converterDtoAModeloSimple(RolDTO rolAConvertir) {
		Rol rolConvertido = new Rol();
		rolConvertido.setIdRol(rolAConvertir.getIdRol());
		rolConvertido.setNombre(rolAConvertir.getNombre());
		return rolConvertido;
	}
	
	public static RolDTO converterModeloADtoCompleto(Rol rolAConvertir) {
		RolDTO rolConvertido = converterModeloADtoSimple(rolAConvertir);
		if(rolAConvertir.getUsuario() != null)
			rolConvertido.setUsuario(UsuarioConverter.converterListaModeloADtoSimple(rolAConvertir.getUsuario()));
		return rolConvertido;
	}
	
	public static Rol converterDtoAModeloCompleto(RolDTO rolAConvertir) {
		Rol rolConvertido = converterDtoAModeloSimple(rolAConvertir);
		if(rolAConvertir.getUsuario() != null)
			rolConvertido.setUsuario(UsuarioConverter.converterListaDtoAModeloSimple(rolAConvertir.getUsuario()));
		return rolConvertido;
	}
	
	public static List<RolDTO> converterModeloADtoSimple(List<Rol> listaRolAConvertir) {
		List<RolDTO> listaRolConvertido = new ArrayList<>();
		for(Rol rolAConvertir :listaRolAConvertir)
			listaRolConvertido.add(converterModeloADtoSimple(rolAConvertir));
		return listaRolConvertido;
	}
	
	public static List<Rol> converterDtoAModeloSimple(List<RolDTO> listaRolAConvertir) {
		List<Rol> listaRolConvertido = new ArrayList<>();
		for(RolDTO rolAConvertir :listaRolAConvertir)
			listaRolConvertido.add(converterDtoAModeloSimple(rolAConvertir));
		return listaRolConvertido;
	}

}
