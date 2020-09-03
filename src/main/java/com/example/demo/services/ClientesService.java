package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Clientes;
import com.example.demo.repository.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<Clientes> consultarTodo() {
		
		return clientesRepository.findAll();
	}

	public Clientes crear(Clientes clientes) {
		
		return clientesRepository.save(clientes);
	}
	
	public Clientes editar(Clientes clientes, Long id) throws Exception {
		Optional<Clientes> responseClient = clientesRepository.findById(id);
		
		if(responseClient.isPresent()) {
			clientes.setId(id);
			return clientesRepository.save(clientes);
		} else {
			throw new Exception("Registro no encontrado");
		}
	}
}
