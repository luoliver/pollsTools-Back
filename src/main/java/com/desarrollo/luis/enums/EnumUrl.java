package com.desarrollo.luis.enums;

public enum EnumUrl {

	HOME("Home","/"),
    LOGIN("Ingreso","/login"),
    SIGNIN("Registrarse", "/registrar"),
    PROFILE("Perfil","/profile"),
    USUARIOS("Usuarios","/usuarios"),
    CATEGORIA("Administrar categorias","/categorias"),
    ROLES("Administrar roles","/roles"),
    ENCUESTAS("Administrar encuestas","/encuestas")
	;
	
	private String titulo;
	private String url;
	
	private EnumUrl(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUrl() {
		return url;
	}
}
