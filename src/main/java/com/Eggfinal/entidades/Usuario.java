package com.Eggfinal.entidades;





import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
public class Usuario {
	
	@Id
	private String documento;
	private String clave;
	private String nombre;
	private String oficio;
	private String email;
	private String telefono;
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	


}
