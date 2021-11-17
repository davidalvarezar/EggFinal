package com.Eggfinal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IniciarSesionController {
	
@GetMapping("/iniciar_sesion")
public String iniciodesesion() {
	
	return/*return"nombre y ruta del html";*/
}

}
