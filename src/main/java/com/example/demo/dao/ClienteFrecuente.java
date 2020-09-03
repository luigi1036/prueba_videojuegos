package com.example.demo.dao;

import java.io.Serializable;

public class ClienteFrecuente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1634489638937340816L;

	private Long total;
	private String nombre;
	private String apellido;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
