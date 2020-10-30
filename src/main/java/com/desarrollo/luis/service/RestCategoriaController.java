package com.desarrollo.luis.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.luis.controller.ICategoriaService;
import com.desarrollo.luis.dto.CategoriaDTO;

/**
 * Metodo que expone los servicios rest para las categorias
 * 
 */
@RestController
@RequestMapping("/api/categorias")
@CrossOrigin("*")
public class RestCategoriaController {

	private static Logger LOGGER = LoggerFactory.getLogger(RestCategoriaController.class);

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<?> listarCategorias(){
		try {
			return ResponseEntity.ok(categoriaService.consultarCategorias());
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/byCodigo/{codigo}")
	public ResponseEntity<?> categoriaPorId(@PathVariable("codigo") String codigo) {
		try {
			return ResponseEntity.ok(categoriaService.consultarPorCodigo(codigo));
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> crearCategoria(@Valid @RequestBody CategoriaDTO categoria) {
		try {
			CategoriaDTO categoriaCreada = categoriaService.crearCategoria(categoria);
			if(categoriaCreada != null)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public BodyBuilder modificarCategoria(@RequestBody CategoriaDTO categoria) {
		CategoriaDTO categoriaModificada = categoriaService.modificarCategoria(categoria);
		if(categoriaModificada != null)
			return ResponseEntity.ok();
		else
			return ResponseEntity.badRequest();
	}
}
