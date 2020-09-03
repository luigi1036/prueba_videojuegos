package com.example.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alquiler;
import com.example.demo.repository.AlquilerRepository;

@Service
public class AlquilerService {

	@Autowired
	private AlquilerRepository alquilerRepository;
	
	public List<Alquiler> consultarTodo() {
		
		return alquilerRepository.findAll();
	}

	public Alquiler crear(Alquiler alquiler) {
		alquiler.setFecha_alquiler(new Date());
		return alquilerRepository.save(alquiler);
	}
}
