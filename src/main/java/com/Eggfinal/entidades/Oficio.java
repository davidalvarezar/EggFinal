package com.Eggfinal.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Oficio {
	
	@Id
	private String nombre;

	@ManyToOne
	private Usuario usuario;
	
}
