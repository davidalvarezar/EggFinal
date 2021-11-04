package com.Eggfinal.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eggfinal.entidades.Oficio;
import com.Eggfinal.errores.ErrorServicio;
import com.Eggfinal.repositorios.OficioRepositorio;

import lombok.Data;

@Data
@Service
public class OficioServicio {
	
	@Autowired
	private OficioRepositorio oficioRepositorio;
	
	public void crearOficio(String nombre) throws ErrorServicio {
		validacionOficio(nombre);
		
		Oficio oficio =new Oficio();
		oficio.setNombre(nombre);
		
		oficioRepositorio.save(oficio);
		
	}
	
	public void modificarOficio(String nombre) throws ErrorServicio {
		validacionOficio(nombre);
		Optional<Oficio> respuesta=oficioRepositorio.findById(nombre);
		if(respuesta.isPresent()) {
			Oficio oficio=respuesta.get();
			
			oficio.setNombre(nombre);
			oficioRepositorio.save(oficio);
		}else {
			throw new ErrorServicio("No se encontró el oficio seleccionado");
		}
	}
	
	public void eliminarOficio(String nombre) throws ErrorServicio {
		validacionOficio(nombre);
		Optional<Oficio> respuesta=oficioRepositorio.findById(nombre);
		if(respuesta.isPresent()) {
			Oficio oficio=respuesta.get();
			
			oficio.setNombre(nombre);
			oficioRepositorio.delete(oficio);
		}else {
			throw new ErrorServicio("No se encontró el oficio seleccionado");
		}
		}
	
	public void validacionOficio(String nombre) throws ErrorServicio {
		if(nombre==null || nombre.isEmpty()) {
			throw new ErrorServicio("El nombre no puede ser nulo o vacío");
		}
	}
	
	
	
	

}
