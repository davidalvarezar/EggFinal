package com.Eggfinal.entidades;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario {
	
	@Id
	private String documento;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	


}
