package com.desarrollo.luis.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.desarrollo.luis.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl(Integer id, String usuario, String contrasena, 
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = usuario;
		this.password = contrasena;
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl build(UsuarioDTO usuarioDto) {
		List<GrantedAuthority> authorities =  new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(usuarioDto.getRolUsuario().getNombre().name()));
		return new UserDetailsImpl(usuarioDto.getId(),usuarioDto.getUsuario(),usuarioDto.getContrasena(),authorities);
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(Object objeto) {
		if(this == objeto)
			return true;
		if(objeto == null || getClass() != objeto.getClass())
			return false;
		UserDetailsImpl usuario = (UserDetailsImpl) objeto;
		return Objects.equals(id, usuario.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
