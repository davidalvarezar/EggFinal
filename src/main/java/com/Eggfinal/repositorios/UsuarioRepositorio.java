package com.Eggfinal.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Eggfinal.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
	
	@Query("SELECT c FROM Usuario c WHERE c.documento = :documento")
	public Usuario buscarPorDocumento(@Param("documento") String documento);
	
	@Query("SELECT c FROM Usuario c WHERE c.email = :email")
	public Usuario getbyEmail(@Param("email") String email);
	
	
	

}
