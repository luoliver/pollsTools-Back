package com.desarrollo.luis.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.IRespuestaService;
import com.desarrollo.luis.converters.PreguntaConverter;
import com.desarrollo.luis.converters.RespuestaConverter;
import com.desarrollo.luis.dto.PreguntaDTO;
import com.desarrollo.luis.dto.RespuestaDTO;
import com.desarrollo.luis.model.Respuesta;
import com.desarrollo.luis.repository.IRespuestaDAO;

@Service
public class RespuestaService implements IRespuestaService{

	@Autowired
	private IRespuestaDAO respuestaDao;
	
	@Override
	public RespuestaDTO crearRespuesta(RespuestaDTO respuesta) {
		Respuesta respuestaAConvertir = respuestaDao.save(RespuestaConverter.converterDtoAModeloCompleto(respuesta));
		return RespuestaConverter.converterModeloADtoSimple(respuestaAConvertir);
	}
	
	@Override
	public List<RespuestaDTO> consultarRespuestaPorPregunta(PreguntaDTO preguntaDto)
	{
		List<Respuesta> listaRepuesta = respuestaDao.findByPregunta(PreguntaConverter.converterDtoAModeloSimple(preguntaDto));
		return RespuestaConverter.converterListaModeloADtoSimple(listaRepuesta);
	}
}
