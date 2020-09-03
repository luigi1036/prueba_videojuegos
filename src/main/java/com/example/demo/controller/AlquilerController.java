package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Alquiler;
import com.example.demo.services.AlquilerService;

@RestController
@RequestMapping("/alquiler")
public class AlquilerController {
	
	@Autowired
	private AlquilerService alquilerService;
	
	@PostMapping("/crear")
	public	ResponseEntity<Alquiler> crear(@RequestBody Alquiler alquiler){
		
		return new ResponseEntity<>(alquilerService.crear(alquiler), HttpStatus.CREATED);
	}
}
