package com.desarrollo.luis.service.response;

import java.io.Serializable;
import java.util.List;

import com.desarrollo.luis.dto.UrlMenuDTO;

public class AuthenticationResponse implements Serializable{

	/**
	 * Define la constante serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private String token;
	
	private String type = "Bearer";
	
	private Integer id;
	
	private String usuario;
	
	private List<UrlMenuDTO> urls;

	public AuthenticationResponse(String token, Integer id, String userName, List<UrlMenuDTO> urls) {
		this.token = token;
		this.id = id;
		this.usuario = userName;
		this.urls = urls;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<UrlMenuDTO> getUrls() {
		return urls;
	}

	public void setUrls(List<UrlMenuDTO> urls) {
		this.urls = urls;
	}
	
}
