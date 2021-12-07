package com.Eggfinal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EditarPerfilController {

@GetMapping("/editarperfil")
public String editarperfil() {

	return"EditProfile.html";
}
	
}

