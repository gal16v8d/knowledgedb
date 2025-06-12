package com.gsdd.knowledgedb.controller;

import static org.mockito.BDDMockito.given;

import com.gsdd.knowledgedb.service.UserService;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

  @Mock private UserService service;
  private UserController controller;

  @BeforeEach
  void setUp() {
    controller = new UserController(service);
  }

  @Test
  void testCancel() {
    Assertions.assertEquals("redirect:/users/list", controller.cancel());
  }

  @Test
  void testList() {
    given(service.listEnabled()).willReturn(Collections.emptyList());
    ModelAndView mav = controller.list();
    Assertions.assertTrue(mav.getModel().containsKey("users"));
  }
}
