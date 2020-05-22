package co.com.gsdd.bdconocimiento.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.com.gsdd.bdconocimiento.constantes.ConstantesServicio;

@Controller
public class IndexControlador {
	
	@GetMapping(ConstantesServicio.U_INDEX)
	public String index(Model model) {
		return ConstantesServicio.INDEX;
	}
}