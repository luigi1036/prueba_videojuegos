package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ClienteFrecuente;
import com.example.demo.dao.Juegos;

@Repository
public class ReportesRepository {

	@Autowired
	EntityManagerFactory emf;

	public List<ClienteFrecuente> cliente_frecuente() {

		List<ClienteFrecuente> clienteFrecuenteList = new ArrayList<>();

		EntityManager em = emf.createEntityManager();

		Query q = em.createNativeQuery("SELECT count(cl.id) as total, cl.nombre, cl.apellido " + "FROM clientes cl "
				+ "INNER JOIN alquiler_clientes_juegos ac on cl.id = ac.id_clientes " + "group by cl.id");

		List<Object[]> c = q.getResultList();

		for (Object[] a : c) {
			ClienteFrecuente clienteFrecuente = new ClienteFrecuente();
			clienteFrecuente.setTotal(Long.parseLong(a[0].toString()));
			clienteFrecuente.setNombre(a[1].toString());
			clienteFrecuente.setApellido(a[2].toString());
			clienteFrecuenteList.add(clienteFrecuente);
		}

		return clienteFrecuenteList;

	}

	public List<Juegos> juegos_frecuentes() {

		List<Juegos> juegosFrecuenteList = new ArrayList<>();

		EntityManager em = emf.createEntityManager();

		Query q = em.createNativeQuery("SELECT count(j.id) as total, j.* " + "FROM prueba.juegos j "
				+ "INNER JOIN prueba.alquiler_clientes_juegos ac on j.id = ac.id_juegos " + "group by j.id");

		List<Object[]> c = q.getResultList();

		for (Object[] a : c) {
			Juegos juegosFrecuente = new Juegos();
			juegosFrecuente.setTotal(Long.parseLong(a[0].toString()));
			juegosFrecuente.setNombre(a[2].toString());
			juegosFrecuente.setAno(Integer.parseInt(a[3].toString()));
			juegosFrecuente.setProtagonista(a[4].toString());
			juegosFrecuente.setDirector(a[5].toString());
			juegosFrecuente.setTecnologia(a[6].toString());
			juegosFrecuente.setPrecio(Long.parseLong(a[7].toString()));
			juegosFrecuenteList.add(juegosFrecuente);
		}
		return juegosFrecuenteList;

	}

	public List<Juegos> ventas_dia(String fecha) {

		List<Juegos> juegosList = new ArrayList<>();

		EntityManager em = emf.createEntityManager();

		Query q = em.createNativeQuery("SELECT j.* " + "FROM prueba.juegos j "
				+ "INNER JOIN prueba.alquiler_clientes_juegos ac on j.id = ac.id_juegos "
				+ "WHERE DATE_FORMAT(ac.fecha_alquiler, '%Y-%m-%d') = ?1").setParameter(1, fecha);

		List<Object[]> c = q.getResultList();

		for (Object[] a : c) {
			Juegos juegos = new Juegos();
			juegos.setNombre(a[1].toString());
			juegos.setAno(Integer.parseInt(a[2].toString()));
			juegos.setProtagonista(a[3].toString());
			juegos.setDirector(a[4].toString());
			juegos.setTecnologia(a[5].toString());
			juegos.setPrecio(Long.parseLong(a[6].toString()));
			juegosList.add(juegos);
		}
		return juegosList;

	}
	
	public List<Juegos> consultar_director(String director) {

		List<Juegos> juegosList = new ArrayList<>();

		EntityManager em = emf.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM prueba.juegos " + 
				"WHERE director LIKE '%"+director+"%'");

		List<Object[]> c = q.getResultList();

		for (Object[] a : c) {
			Juegos juegos = new Juegos();
			juegos.setNombre(a[1].toString());
			juegos.setAno(Integer.parseInt(a[2].toString()));
			juegos.setProtagonista(a[3].toString());
			juegos.setDirector(a[4].toString());
			juegos.setTecnologia(a[5].toString());
			juegos.setPrecio(Long.parseLong(a[6].toString()));
			juegosList.add(juegos);
		}
		return juegosList;

	}
	
	public List<Juegos> consultar_protagonista(String protagonista) {

		List<Juegos> juegosList = new ArrayList<>();

		EntityManager em = emf.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM prueba.juegos " + 
				"WHERE protagonista LIKE '%"+protagonista+"%'");

		List<Object[]> c = q.getResultList();

		for (Object[] a : c) {
			Juegos juegos = new Juegos();
			juegos.setNombre(a[1].toString());
			juegos.setAno(Integer.parseInt(a[2].toString()));
			juegos.setProtagonista(a[3].toString());
			juegos.setDirector(a[4].toString());
			juegos.setTecnologia(a[5].toString());
			juegos.setPrecio(Long.parseLong(a[6].toString()));
			juegosList.add(juegos);
		}
		return juegosList;

	}
	
	public List<Juegos> consultar_productor(String productor) throws Exception {
		
		try {
			List<Juegos> juegosList = new ArrayList<>();

			EntityManager em = emf.createEntityManager();

			Query q = em.createNativeQuery("SELECT * FROM prueba.juegos " + 
					"WHERE tecnologia LIKE '%"+productor+"%'");

			List<Object[]> c = q.getResultList();

			for (Object[] a : c) {
				Juegos juegos = new Juegos();
				juegos.setNombre(a[1].toString());
				juegos.setAno(Integer.parseInt(a[2].toString()));
				juegos.setProtagonista(a[3].toString());
				juegos.setDirector(a[4].toString());
				juegos.setTecnologia(a[5].toString());
				juegos.setPrecio(Long.parseLong(a[6].toString()));
				juegosList.add(juegos);
			}
			return juegosList;
		} catch (Exception e) {
			throw new Exception("Ocurrio un error al intentar consultar el productor: " + e.getMessage());
		}

	}

	
}
