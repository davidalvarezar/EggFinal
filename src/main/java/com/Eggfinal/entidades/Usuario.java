package com.Eggfinal.entidades;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

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
