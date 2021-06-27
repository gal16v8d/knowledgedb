package co.com.gsdd.knowledgedb.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import co.com.gsdd.knowledgedb.domain.Usuario;
import co.com.gsdd.knowledgedb.service.IUsuarioService;

public class UsuarioControllerTest {

	@Mock
	private IUsuarioService service;
	private UsuarioController controller;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new UsuarioController(service);
	}

	@Test
	public void cancelTest() {
		Assertions.assertEquals("redirect:/usuario/listar", controller.cancel());
	}
	
	@Test
    public void listTest() {
        List<Usuario> lUser = new ArrayList<>();
        Mockito.when(service.listEnabled()).thenReturn(lUser);
        ModelAndView mav = controller.list();
        Assertions.assertTrue(mav.getModel().containsKey("usuarios"));
    }

}
