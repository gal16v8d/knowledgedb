package com.gsdd.knowledgedb.controller;

import com.gsdd.knowledgedb.constants.ServiceConstants;
import com.gsdd.knowledgedb.domain.Caso;
import com.gsdd.knowledgedb.service.CasoService;
import com.gsdd.knowledgedb.service.EstadoCasoService;
import com.gsdd.knowledgedb.service.TipoCasoService;
import com.gsdd.knowledgedb.service.UsuarioService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = ServiceConstants.U_CASO)
public class CasoController {

  private static final String CASO_OBJ = "caso";
  private static final String CASO_LISTA = "casos";
  private static final String USU_LISTA = "usuarios";
  private static final String E_LISTA = "estados";
  private static final String T_LISTA = "tipos";

  private final CasoService casoService;
  private final UsuarioService usuarioService;
  private final EstadoCasoService estadoCasoService;
  private final TipoCasoService tipoCasoService;

  @GetMapping(ServiceConstants.M_CANCELAR)
  public String cancel() {
    return seeList();
  }

  @GetMapping(ServiceConstants.M_LISTAR)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView(CASO_LISTA);
    mav.addObject(CASO_LISTA, casoService.listEnabled());
    return mav;
  }

  @GetMapping(ServiceConstants.F_CASO)
  public String goToForm(
      @RequestParam(name = ServiceConstants.P_ID, required = false) Long id, Model model) {
    Caso c = Optional.ofNullable(id).map(casoService::findById).orElse(new Caso());
    model.addAttribute(CASO_OBJ, c);
    obtenerListaUsuario(model);
    getEstadoList(model);
    getTipoList(model);
    return ServiceConstants.F_CASO;
  }

  @PostMapping(value = ServiceConstants.M_GUARDAR)
  public String save(@ModelAttribute(CASO_OBJ) Caso c, Model model) {
    if (c.getCodigoCaso() == null) {
      casoService.save(c);
    } else {
      casoService.update(c);
    }
    return seeList();
  }

  @GetMapping(value = ServiceConstants.M_ELIMINAR)
  public ModelAndView delete(@RequestParam(name = ServiceConstants.P_ID, required = true) Long id) {
    casoService.logicalDelete(id);
    return list();
  }

  public Model obtenerListaUsuario(Model model) {
    model.addAttribute(USU_LISTA, usuarioService.listEnabled());
    return model;
  }

  public Model getEstadoList(Model model) {
    model.addAttribute(E_LISTA, estadoCasoService.listEnabled());
    return model;
  }

  public Model getTipoList(Model model) {
    model.addAttribute(T_LISTA, tipoCasoService.listEnabled());
    return model;
  }

  private String seeList() {
    StringBuilder sb =
        new StringBuilder()
            .append(ServiceConstants.REDIRECT)
            .append(ServiceConstants.U_CASO)
            .append(ServiceConstants.SLASH)
            .append(ServiceConstants.M_LISTAR);
    return sb.toString();
  }
}
