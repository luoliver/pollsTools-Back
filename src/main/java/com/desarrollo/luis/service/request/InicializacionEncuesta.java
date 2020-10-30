package com.desarrollo.luis.service.request;

import com.desarrollo.luis.dto.EncuestaDTO;
import com.desarrollo.luis.dto.UsuarioDTO;

public class InicializacionEncuesta {

	private EncuestaDTO encuesta;
	
	private UsuarioDTO usuario;

	public EncuestaDTO getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(EncuestaDTO encuesta) {
		this.encuesta = encuesta;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}
