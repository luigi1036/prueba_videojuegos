package com.example.demo.dao;

import java.io.Serializable;

public class Clientes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2608825073950805726L;
	
	private int id;
	private String nombre;
	private String apellido;
	private String tipo_documento;
	private String numero_documento;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}
	

}
