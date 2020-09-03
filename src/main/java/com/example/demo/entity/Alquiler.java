package com.example.demo.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="alquiler_clientes_juegos")
public class Alquiler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int id_clientes;
	private int id_juegos;
	
	private Date fecha_alquiler;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getId_clientes() {
		return id_clientes;
	}
	public void setId_clientes(int id_clientes) {
		this.id_clientes = id_clientes;
	}
	public int getId_juegos() {
		return id_juegos;
	}
	public void setId_juegos(int id_juegos) {
		this.id_juegos = id_juegos;
	}
	public Date getFecha_alquiler() {
		return fecha_alquiler;
	}
	public void setFecha_alquiler(Date fecha_alquiler) {
		this.fecha_alquiler = fecha_alquiler;
	}
	

}
