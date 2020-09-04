package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Juegos;
import com.example.demo.entity.Clientes;
import com.example.demo.services.ReportesService;

@RestController
@CrossOrigin
@RequestMapping("/reportes")
public class ReportesController {

	@Autowired
	ReportesService reportesService;

	@GetMapping("/cliente_frecuente")
	public ResponseEntity<List<Map<String, Object>>> cliente_frecuente() {

		return new ResponseEntity<>(reportesService.cliente_frecuente(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/juegos_frecuentes")
	public ResponseEntity<List<Map<String, Object>>> juegos_frecuentes() {

		return new ResponseEntity<>(reportesService.juegos_frecuente(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/ventas_dia")
	public ResponseEntity<List<Juegos>> ventas_dia() {

		return new ResponseEntity<>(reportesService.ventas_dia(), HttpStatus.ACCEPTED);
	}

	@PostMapping("/consultar_director")
	public ResponseEntity<List<Juegos>> consultar_director(@RequestBody Map<String, String> datos) {

		return new ResponseEntity<>(reportesService.consultar_director(datos.get("nombre_director").toString()),
				HttpStatus.ACCEPTED);
	}

	@PostMapping("/consultar_protagonista")
	public ResponseEntity<List<Juegos>> consultar_protagonista(@RequestBody Map<String, String> datos) {

		return new ResponseEntity<>(reportesService.consultar_protagonista(datos.get("nombre_protagonista").toString()),
				HttpStatus.ACCEPTED);
	}

	@PostMapping("/consultar_productor")
	public ResponseEntity<List<Juegos>> consultar_productor(@RequestBody Map<String, String> datos) throws Exception {
		if (datos == null || datos.get("nombre_productor") == null) {
			throw new Exception("No se enviaron datos de consulta.");
		}
		return new ResponseEntity<>(reportesService.consultar_productor(datos.get("nombre_productor").toString()),
				HttpStatus.ACCEPTED);
	}
}