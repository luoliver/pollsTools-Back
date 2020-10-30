package com.desarrollo.luis.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.IEncuestaService;
import com.desarrollo.luis.dto.CategoriaDTO;
import com.desarrollo.luis.dto.EncuestaDTO;

/**
 * Metodo que expone los servicios rest para las categorias
 * 
 */
@RestController
@RequestMapping("/api/encuestas")
@CrossOrigin("*")
public class RestEncuestaController {

	private static Logger LOGGER = LoggerFactory.getLogger(RestEncuestaController.class);

	@Autowired
	private IEncuestaService encuestaService;

	@GetMapping
	public ResponseEntity<?> listarEncuestas(){
		try {
			return ResponseEntity.ok(encuestaService.listarEncuestas());
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/byCategoria")
	public ResponseEntity<?> listarEncuestasPorCategoria(@RequestBody CategoriaDTO categoria) {
		try {
			return ResponseEntity.ok(encuestaService.listarEncuestaPorCategoria(categoria));
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/byCodigo/{codigo}")
	public ResponseEntity<?> consutlarEncuestaPorId(@PathVariable("codigo") String codigo) {
		try {
			return ResponseEntity.ok(encuestaService.consultarEncuestaPorCodigo(codigo));
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> crearCategoria(@Valid @RequestBody EncuestaDTO encuestaDto) {
		try {
			EncuestaDTO encuestaRespuestaDto = encuestaService.crearEncuesta(encuestaDto);
			if(encuestaRespuestaDto != null)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
