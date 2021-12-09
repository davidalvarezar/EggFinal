package com.Eggfinal.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Eggfinal.errores.ErrorServicio;
import com.Eggfinal.servicios.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServicio usuarioservicio;

	@GetMapping("/registro")
	public String registro() {
		return "usuario/agregar.html";
	}

	@PostMapping("/registro")
	public String guardarUsuario(@RequestParam String documento, @RequestParam String clave,
			@RequestParam String nombre, @RequestParam String oficio, @RequestParam String email,
			@RequestParam String telefono) throws ErrorServicio {
		usuarioservicio.crearUsuario(documento, nombre, clave, oficio, email, telefono);
		return "usuario/agregar.html";
	}
}
