package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dao.ClienteFrecuente;
import com.example.demo.entity.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

	
}
