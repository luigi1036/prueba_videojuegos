package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Clientes;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@PostMapping("/crear")
	public	Clientes crear(@RequestBody Clientes clientes){
		
		System.out.println("Entrando al controlador");
		return null;
	}
	
	
}
