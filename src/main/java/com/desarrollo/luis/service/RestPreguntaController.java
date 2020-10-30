package com.desarrollo.luis.service;

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

import com.desarrollo.luis.controller.IPreguntaService;
import com.desarrollo.luis.dto.EncuestaDTO;
import com.desarrollo.luis.dto.PreguntaDTO;

/**
 * Metodo que expone los servicios rest para las categorias
 * 
 */
@RestController
@RequestMapping("/api/preguntas")
@CrossOrigin("*")
public class RestPreguntaController {

	private static Logger LOGGER = LoggerFactory.getLogger(RestPreguntaController.class);

	@Autowired
	private IPreguntaService preguntaService;

	@PostMapping("/byEncuesta")
	public ResponseEntity<?> listarPreguntas(@RequestBody EncuestaDTO encuestaDto){
		try {
			return ResponseEntity.ok(preguntaService.consultarPreguntasPorEncuesta(encuestaDto));
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> crearPregunta(@RequestBody PreguntaDTO preguntaDto) {
		try {
			PreguntaDTO preguntaCreada = preguntaService.crearPregunta(preguntaDto);
			if(preguntaCreada != null)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
