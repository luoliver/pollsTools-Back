package com.desarrollo.luis.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.IEncuestaService;
import com.desarrollo.luis.converters.CategoriaConverter;
import com.desarrollo.luis.converters.EncuestaConverter;
import com.desarrollo.luis.dto.CategoriaDTO;
import com.desarrollo.luis.dto.EncuestaDTO;
import com.desarrollo.luis.model.Encuesta;
import com.desarrollo.luis.repository.IEncuestaDAO;

@Service
public class EncuestaService implements IEncuestaService{

	@Autowired
	private IEncuestaDAO encuestaDao;
	
	@Override
	public EncuestaDTO crearEncuesta(EncuestaDTO encuestaDto) {
		if(encuestaDao.existsByCodigo(encuestaDto.getCodigo()))
			return null;
		Encuesta encuestaCreada = encuestaDao.save(EncuestaConverter.converterDtoAModeloCompleto(encuestaDto));
		return EncuestaConverter.converterModeloADtoSimple(encuestaCreada);
	}
	
	@Override
	public List<EncuestaDTO> listarEncuestas(){
		List<Encuesta> listaEncuesta = encuestaDao.findAll();
		return EncuestaConverter.converterListaModeloADtoCategoria(listaEncuesta);
	}
	
	@Override
	public List<EncuestaDTO> listarEncuestaPorCategoria(CategoriaDTO categoriaDto){
		List<Encuesta> listaEncuesta = encuestaDao.findByCategoria(CategoriaConverter.converterDtoAModeloSimple(categoriaDto));
		return EncuestaConverter.converterListaModeloADtoSimple(listaEncuesta);
	}
	
	@Override
	public EncuestaDTO consultarEncuestaPorCodigo(String codigo){
		Encuesta encuesta = encuestaDao.findByCodigo(codigo);
		return EncuestaConverter.converterModeloADtoSimple(encuesta);
	}
	
	@Override
	public Integer cantidadPreguntasEncuesta(EncuestaDTO encuestaDto) {
		return 0;
	}
}
