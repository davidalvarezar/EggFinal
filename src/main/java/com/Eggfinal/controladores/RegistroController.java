package com.Eggfinal.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Eggfinal.errores.ErrorServicio;
import com.Eggfinal.servicios.UsuarioServicio;

@Controller
@RequestMapping("/")
public class RegistroController {
	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping("/registrate")
	public String registrousuario() {

		return "Registro.html";
	}

	@PostMapping("/registrar")
	public String registrar(ModelMap modelo, @RequestParam String nombre, @RequestParam String Documento,
			@RequestParam String correo, @RequestParam String telefono, @RequestParam String Contraseña, @RequestParam String oficio)
			throws ErrorServicio {
		usuarioServicio.crearUsuario(nombre, Documento, correo, telefono, Contraseña, oficio);
		return "Login.html";
	}
}
