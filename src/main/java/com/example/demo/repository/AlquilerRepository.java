package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

	
}
