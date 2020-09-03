package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClienteFrecuente;
import com.example.demo.dao.Juegos;
import com.example.demo.repository.ReportesRepository;

@Service
public class ReportesService {

	@Autowired
	ReportesRepository reportesRepository;

	public List<Map<String, Object>> cliente_frecuente() {
		List<Map<String, Object>> clienteFrecuenteList = new ArrayList<>();
		List<ClienteFrecuente> listClientes = reportesRepository.cliente_frecuente();

		listClientes.stream().sorted(Comparator.comparingLong(ClienteFrecuente::getTotal).reversed()).forEach(t -> {
			Map<String, Object> clienteFrecuente = new HashMap<>();
			clienteFrecuente.put("total", t.getTotal());
			clienteFrecuente.put("nombre", t.getNombre());
			clienteFrecuente.put("apellido", t.getApellido());

			clienteFrecuenteList.add(clienteFrecuente);
		});

		return clienteFrecuenteList;
	}

	public List<Map<String, Object>> juegos_frecuente() {
		List<Map<String, Object>> juegosFrecuenteList = new ArrayList<>();
		List<Juegos> listJuegos = reportesRepository.juegos_frecuentes();

		listJuegos.stream().sorted(Comparator.comparingLong(Juegos::getTotal).reversed()).forEach(t -> {
			Map<String, Object> juegosFrecuentes = new HashMap<>();
			juegosFrecuentes.put("total", t.getTotal());
			juegosFrecuentes.put("nombre", t.getNombre());
			juegosFrecuentes.put("ano", t.getAno());
			juegosFrecuentes.put("protagonista", t.getProtagonista());
			juegosFrecuentes.put("director", t.getDirector());
			juegosFrecuentes.put("tecnologia", t.getTecnologia());

			juegosFrecuenteList.add(juegosFrecuentes);
		});

		return juegosFrecuenteList;
	}

	public List<Juegos> ventas_dia() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());

		return reportesRepository.ventas_dia(formatter.format(date));
	}

	public List<Juegos> consultar_director(String nombre_director) {

		return reportesRepository.consultar_director(nombre_director);
	}

	public List<Juegos> consultar_protagonista(String nombre_protagonista) {

		return reportesRepository.consultar_protagonista(nombre_protagonista);
	}

	public List<Juegos> consultar_productor(String nombre_productor) throws Exception {

		return reportesRepository.consultar_productor(nombre_productor);
	}
}
