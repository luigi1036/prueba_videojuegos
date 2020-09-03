package com.example.demo.dao;

import java.io.Serializable;

public class Juegos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long total;
	private String nombre;
	private int ano;
	private String protagonista;
	private String director;
	private String tecnologia;
	private Long precio;
	
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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getProtagonista() {
		return protagonista;
	}
	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	

}
