package com.gsdd.knowledgedb.controller;

import com.gsdd.knowledgedb.constants.ServiceConstants;
import com.gsdd.knowledgedb.domain.User;
import com.gsdd.knowledgedb.service.UserService;
import jakarta.validation.Valid;
import java.util.Optional;
import java.util.UUID;
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
@RequestMapping(value = ServiceConstants.U_USER)
public class UserController {

  private static final String USER_OBJ = "user";
  private static final String USER_LIST = "users";
  private static final String USER_FORM = "userForm";

  private final UserService service;

  @GetMapping(ServiceConstants.M_CANCEL)
  public String cancel() {
    return seeList();
  }

  @GetMapping(ServiceConstants.M_LIST)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView(USER_LIST);
    mav.addObject(USER_LIST, service.listEnabled());
    return mav;
  }

  @GetMapping(ServiceConstants.FORM)
  public String goToForm(
      @RequestParam(name = ServiceConstants.P_ID, required = false) UUID id, Model model) {
    User user = Optional.ofNullable(id).map(service::findById).orElseGet(User::new);
    model.addAttribute(USER_OBJ, user);
    return USER_FORM;
  }

  @PostMapping(value = ServiceConstants.M_SAVE)
  public ModelAndView save(
      @Valid @ModelAttribute(USER_OBJ) User user, Model model, BindingResult binding) {
    ModelAndView mav = new ModelAndView();
    if (binding.hasErrors()) {
      mav.setViewName(USER_FORM);
      mav.addObject(ServiceConstants.BAD, ServiceConstants.BAD);
    } else {
      if (user.getUserCode() == null) {
        service.save(user);
      } else {
        service.update(user);
      }
      mav = list();
      mav.addObject(ServiceConstants.BAD, ServiceConstants.OK);
    }
    return mav;
  }

  @GetMapping(value = ServiceConstants.M_DELETE)
  public ModelAndView delete(@RequestParam(name = ServiceConstants.P_ID) UUID id) {
    service.logicalDelete(id);
    return list();
  }

  private String seeList() {
    return new StringBuilder()
        .append(ServiceConstants.REDIRECT)
        .append(ServiceConstants.U_USER)
        .append(ServiceConstants.SLASH)
        .append(ServiceConstants.M_LIST)
        .toString();
  }
}
