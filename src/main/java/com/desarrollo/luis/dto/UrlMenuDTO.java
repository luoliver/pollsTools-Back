package com.desarrollo.luis.dto;

import com.desarrollo.luis.enums.EnumUrl;

public class UrlMenuDTO {

	private String titulo;
	private String url;
	
	public UrlMenuDTO(EnumUrl enumUrl) {
		this.titulo = enumUrl.getTitulo();
		this.url = enumUrl.getUrl();
	}
	
	public UrlMenuDTO() {
		//Constructor vacio
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
