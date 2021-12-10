package com.gsdd.knowledgedb.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import com.gsdd.knowledgedb.domain.Usuario;
import com.gsdd.knowledgedb.service.IUsuarioService;

class UsuarioControllerTest {

  @Mock
  private IUsuarioService service;
  private UsuarioController controller;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    controller = new UsuarioController(service);
  }

  @Test
  void testCancel() {
    Assertions.assertEquals("redirect:/usuario/listar", controller.cancel());
  }

  @Test
  void testList() {
    List<Usuario> lUser = new ArrayList<>();
    Mockito.when(service.listEnabled()).thenReturn(lUser);
    ModelAndView mav = controller.list();
    Assertions.assertTrue(mav.getModel().containsKey("usuarios"));
  }

}
