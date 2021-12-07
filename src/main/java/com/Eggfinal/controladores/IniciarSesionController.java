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
public class IniciarSesionController {
	@Autowired
	private UsuarioServicio usuarioServicio;
	@GetMapping("/login")
	public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout,
			ModelMap model) {
		if (error != null) {
			model.put("error", "Usuario o clave incorrectos");
		}
		if (logout != null) {
			model.put("logout", "Ha salido correctamente.");
		}
		return "Login.html";
	}

}