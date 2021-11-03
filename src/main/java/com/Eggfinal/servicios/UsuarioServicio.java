package com.Eggfinal.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eggfinal.entidades.Usuario;
import com.Eggfinal.errores.ErrorServicio;
import com.Eggfinal.repositorios.UsuarioRepositorio;

import lombok.Data;

@Data
@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public void crearUsuario(String documento, String nombre, String apellido, String email, String telefono) throws ErrorServicio {
		
		validacionDatos(documento, nombre, apellido, email, telefono);
		
		Usuario usuario=new Usuario();
		usuario.setDocumento(documento);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		
		usuarioRepositorio.save(usuario);
		
	}
	
	public void modificarUsuario(String documento, String nombre, String apellido, String email, String telefono) throws ErrorServicio {
		validacionDatos(documento, nombre, apellido, email, telefono);
		
		Optional<Usuario> respuesta=usuarioRepositorio.findById(documento);
		if (respuesta.isPresent()) {
			Usuario usuario=respuesta.get();
			
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setTelefono(telefono);
			usuario.setEmail(email);
			
			usuarioRepositorio.save(usuario);
		}else {
			throw new ErrorServicio ("No se encontró el usuario solicitado(modificar usuario)");
		}
			
			}
	
	public void eliminarUsuario(String documento) throws ErrorServicio {
		validacionDni(documento);
		
		Optional<Usuario> respuesta=usuarioRepositorio.findById(documento);
		if (respuesta.isPresent()) {
			
			Usuario usuario=respuesta.get();
			
			usuarioRepositorio.delete(usuario);
			
		}else {
			throw new ErrorServicio("No se encontró el usuario solicitado(eliminar usuario)");
		}
	
	}
	
	public void validacionDatos(String documento, String nombre, String apellido, String email, String telefono) throws ErrorServicio  {
		if (documento==null || documento.isEmpty()) {
			throw new ErrorServicio("El documento del usuario no puede ser nulo ni vacío");
		}
		if (nombre==null || nombre.isEmpty()) {
			throw new ErrorServicio("El nombre del usuario no puede ser nulo ni vacío");
		}
		if (apellido==null || apellido.isEmpty()) {
			throw new ErrorServicio("El apellido del usuario no puede ser nulo ni vacío");
		}
		if (email==null || email.isEmpty()) {
			throw new ErrorServicio("El email del usuario no puede ser nulo ni vacío");
		}
		if (telefono==null || telefono.isEmpty()) {
			throw new ErrorServicio("El telefono del usuario no puede ser nulo ni vacío");
		}
		
	}
	
	public void validacionDni(String documento) throws ErrorServicio {
		if (documento==null || documento.isEmpty()) {
			throw new ErrorServicio("El documento del usuario no puede ser nulo ni vacío");
		}
		
	}
	
	

}
