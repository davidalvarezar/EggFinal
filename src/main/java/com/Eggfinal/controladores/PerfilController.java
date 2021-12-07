package com.Eggfinal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class PerfilController {
@GetMapping("/perfil")
public String perfil() {
	return"Profile.html";
}
@GetMapping("/profile")
public String profile() {

	return"EditProfile.html";
}


	
}
