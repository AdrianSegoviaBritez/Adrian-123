package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
public class PrincipalController {
	@RequestMapping("/iniciar")
	  public String paginaInicio() {
			System.out.println("Ingrese al controlador");
		  return "index";
}
}
