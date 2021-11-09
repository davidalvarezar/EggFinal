package com.Eggfinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eggfinal.entidades.Oficio;

@Repository
public interface OficioRepositorio extends JpaRepository<Oficio, String>{
	
	

}
