package com.desarrollo.luis.controller.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.IUsuarioService;
import com.desarrollo.luis.converters.UsuarioConverter;
import com.desarrollo.luis.dto.UsuarioDTO;
import com.desarrollo.luis.model.Usuario;
import com.desarrollo.luis.repository.IUsuarioDAO;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioDAO usuarioDao;

	@Override
	public UsuarioDTO consultarPorUsuario(String usuario) {
		Usuario resultado = usuarioDao.findByUsuario(usuario);
		if(resultado == null)
			throw new UsernameNotFoundException("User Not Found with username: " + usuario);
		return UsuarioConverter.converterModeloADtoSimple(resultado);
	}

	@Override
	public UsuarioDTO crearUsuarioAdminsitrador(UsuarioDTO usuario) {
		Usuario usuarioCrear = UsuarioConverter.converterDtoAModeloSimple(usuario);
		Usuario resultado = usuarioDao.save(usuarioCrear);
		return UsuarioConverter.converterModeloADtoSimple(resultado);
	}
	
	@Override
	public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws Exception {
		if(usuarioDao.existsByUsuario(usuario.getUsuario()))
			throw new Exception("Usuario ya existe");
		Usuario usuarioCrear = UsuarioConverter.converterDtoAModeloSimple(usuario);
		Usuario resultado = usuarioDao.save(usuarioCrear);
		return UsuarioConverter.converterModeloADtoSimple(resultado);
	}

	@Override
	public List<UsuarioDTO> consultarUsuarios() {
		List<Usuario> resultado = usuarioDao.findAll();
		return UsuarioConverter.converterListaModeloADtoSimple(resultado);
	}

	@Override
	public UsuarioDTO modificarUsuario(UsuarioDTO usuario) {
		Optional<Usuario> validacion = usuarioDao.findById(usuario.getId());
		if(validacion.isEmpty())
			return null;
		Usuario resultado = usuarioDao.save(UsuarioConverter.converterDtoAModeloSimple(usuario));
		return UsuarioConverter.converterModeloADtoSimple(resultado);
	}

	@Override
	public Boolean eliminarUsuario(Integer id) {
		usuarioDao.deleteById(id);
		Optional<Usuario> validacion = usuarioDao.findById(id);
		return (validacion.isEmpty());
	}

}
