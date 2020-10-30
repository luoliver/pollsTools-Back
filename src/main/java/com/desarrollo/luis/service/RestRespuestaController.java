package com.desarrollo.luis.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.IRespuestaService;
import com.desarrollo.luis.dto.PreguntaDTO;
import com.desarrollo.luis.dto.RespuestaDTO;

/**
 * Metodo que expone los servicios rest para las categorias
 * 
 */
@RestController
@RequestMapping("/api/respuestas")
@CrossOrigin("*")
public class RestRespuestaController {

	private static Logger LOGGER = LoggerFactory.getLogger(RestRespuestaController.class);

	@Autowired
	private IRespuestaService respuestaService;

	@PostMapping("/byPregunta")
	public ResponseEntity<?> listarPreguntas(@RequestBody PreguntaDTO preguntaDto){
		try {
			return ResponseEntity.ok(respuestaService.consultarRespuestaPorPregunta(preguntaDto));
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> crearRespuesta(@Valid @RequestBody RespuestaDTO respuesta) {
		try {
			RespuestaDTO respuestaCreada = respuestaService.crearRespuesta(respuesta);
			if(respuestaCreada != null)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
