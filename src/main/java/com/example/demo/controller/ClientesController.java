package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Clientes;
import com.example.demo.services.ClientesService;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesService clientesService;

	@PostMapping("/crear")
	public	ResponseEntity<Clientes> crear(@RequestBody Clientes clientes){
		
		return new ResponseEntity<>(clientesService.crear(clientes), HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Clientes> editar(@PathVariable Long id, @RequestBody Clientes clientes) throws Exception {
		
		return new ResponseEntity<>(clientesService.editar(clientes, id), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/consultarTodos")
	public ResponseEntity<List<Clientes>> consultarTodos() {
		return new ResponseEntity<>(clientesService.consultarTodo(), HttpStatus.ACCEPTED);
	}
	
	
}
