package com.Eggfinal.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Eggfinal.entidades.Usuario;
import com.Eggfinal.errores.ErrorServicio;
import com.Eggfinal.repositorios.UsuarioRepositorio;

import lombok.Data;

@Data
@Service
public class UsuarioServicio implements UserDetailsService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public void crearUsuario(String documento, String clave, String nombre, String apellido, String email, String telefono) throws ErrorServicio {
		
		validacionDatos(documento, clave, nombre, apellido, email, telefono);
		
		Usuario usuario=new Usuario();
		
		usuario.setDocumento(documento);
		usuario.setClave(clave);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		
		usuarioRepositorio.save(usuario);
		
	}
	
	public void modificarUsuario(String documento,String clave, String nombre, String apellido, String email, String telefono) throws ErrorServicio {
		validacionDatos(documento,clave, nombre, apellido, email, telefono);
		
		Optional<Usuario> respuesta=usuarioRepositorio.findById(documento);
		if (respuesta.isPresent()) {
			Usuario usuario=respuesta.get();

			usuario.setClave(clave);
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
	
	public void validacionDatos(String documento,String clave, String nombre, String apellido, String email, String telefono) throws ErrorServicio  {
		if (documento==null || documento.isEmpty()) {
			throw new ErrorServicio("El documento del usuario no puede ser nulo ni vacío");
		}
		if (clave==null || clave.isEmpty()) {
			throw new ErrorServicio("La clave del usuario no puede ser nulo ni vacío");
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
			throw new ErrorServicio("El teléfono del usuario no puede ser nulo ni vacío");
		}
		
	}
	
	public void validacionDni(String documento) throws ErrorServicio {
		if (documento==null || documento.isEmpty()) {
			throw new ErrorServicio("El documento del usuario no puede ser nulo ni vacío");
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String documento) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.buscarPorDocumento(documento);
		if (usuario != null) {
			
			List<GrantedAuthority> permisos = new ArrayList<>();
			
			GrantedAuthority p = new SimpleGrantedAuthority("MODULO_OFICIOS");
			permisos.add(p);
			
			
			User user = new User(usuario.getDocumento(), usuario.getClave(), permisos);
			return user;
			
		}else {
			return null;
		}
		
	}

		
		
	
	
	

}
