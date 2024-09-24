package com.gsdd.knowledgedb.controller;

import com.gsdd.knowledgedb.constants.ServiceConstants;
import com.gsdd.knowledgedb.domain.Usuario;
import com.gsdd.knowledgedb.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = ServiceConstants.U_USUARIO)
public class UsuarioController {

  private static final String USU_OBJ = "usuario";
  private static final String USU_LISTA = "usuarios";

  private final UsuarioService service;

  @GetMapping(ServiceConstants.M_CANCELAR)
  public String cancel() {
    return seeList();
  }

  /**
   * Permite mapear a vista la lista de usuarios.
   *
   * @return
   */
  @GetMapping(ServiceConstants.M_LISTAR)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView(USU_LISTA);
    mav.addObject(USU_LISTA, service.listEnabled());
    return mav;
  }

  @GetMapping(ServiceConstants.F_USUARIO)
  public String goToForm(
      @RequestParam(name = ServiceConstants.P_ID, required = false) Long id, Model model) {
    Usuario usuario = Optional.ofNullable(id).map(service::findById).orElseGet(Usuario::new);
    model.addAttribute(USU_OBJ, usuario);
    return ServiceConstants.F_USUARIO;
  }

  @PostMapping(value = ServiceConstants.M_GUARDAR)
  public ModelAndView save(
      @Valid @ModelAttribute(USU_OBJ) Usuario usuario, Model model, BindingResult binding) {
    ModelAndView mav = new ModelAndView();
    if (binding.hasErrors()) {
      mav.setViewName(ServiceConstants.F_USUARIO);
      mav.addObject(ServiceConstants.BAD, ServiceConstants.BAD);
    } else {
      if (usuario.getCodigo() == null) {
        service.save(usuario);
      } else {
        service.update(usuario);
      }
      mav = list();
      mav.addObject(ServiceConstants.BAD, ServiceConstants.OK);
    }
    return mav;
  }

  @GetMapping(value = ServiceConstants.M_ELIMINAR)
  public ModelAndView delete(@RequestParam(name = ServiceConstants.P_ID, required = true) Long id) {
    service.logicalDelete(id);
    return list();
  }

  private String seeList() {
    return new StringBuilder()
        .append(ServiceConstants.REDIRECT)
        .append(ServiceConstants.U_USUARIO)
        .append(ServiceConstants.SLASH)
        .append(ServiceConstants.M_LISTAR)
        .toString();
  }
}
