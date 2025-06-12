package com.gsdd.knowledgedb.controller;

import com.gsdd.knowledgedb.constants.ServiceConstants;
import com.gsdd.knowledgedb.domain.Ticket;
import com.gsdd.knowledgedb.service.TicketService;
import com.gsdd.knowledgedb.service.TicketStatusService;
import com.gsdd.knowledgedb.service.TicketTypeService;
import com.gsdd.knowledgedb.service.UserService;
import java.util.Optional;
import java.util.UUID;
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
@RequestMapping(value = ServiceConstants.U_TICKET)
public class TicketController {

  private static final String TICKET_OBJ = "ticket";
  private static final String TICKET_LIST = "tickets";
  private static final String TICKET_FORM = "ticketForm";
  private static final String USER_LIST = "users";
  private static final String STATUS_LIST = "status";
  private static final String TYPE_LIST = "types";

  private final TicketService ticketService;
  private final UserService userService;
  private final TicketStatusService ticketStatusService;
  private final TicketTypeService ticketTypeService;

  @GetMapping(ServiceConstants.M_CANCEL)
  public String cancel() {
    return seeList();
  }

  @GetMapping(ServiceConstants.M_LIST)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView(TICKET_LIST);
    mav.addObject(TICKET_LIST, ticketService.listEnabled());
    return mav;
  }

  @GetMapping(ServiceConstants.FORM)
  public String goToForm(
      @RequestParam(name = ServiceConstants.P_ID, required = false) UUID id, Model model) {
    Ticket ticket = Optional.ofNullable(id).map(ticketService::findById).orElseGet(Ticket::new);
    model.addAttribute(TICKET_OBJ, ticket);
    getUserList(model);
    getTicketStatusList(model);
    getTicketTypeList(model);
    return TICKET_FORM;
  }

  @PostMapping(value = ServiceConstants.M_SAVE)
  public String save(@ModelAttribute(TICKET_OBJ) Ticket t, Model model) {
    if (t.getTicketCode() == null) {
      ticketService.save(t);
    } else {
      ticketService.update(t);
    }
    return seeList();
  }

  @GetMapping(value = ServiceConstants.M_DELETE)
  public ModelAndView delete(@RequestParam(name = ServiceConstants.P_ID) UUID id) {
    ticketService.logicalDelete(id);
    return list();
  }

  public Model getUserList(Model model) {
    model.addAttribute(USER_LIST, userService.listEnabled());
    return model;
  }

  public Model getTicketStatusList(Model model) {
    model.addAttribute(STATUS_LIST, ticketStatusService.listEnabled());
    return model;
  }

  public Model getTicketTypeList(Model model) {
    model.addAttribute(TYPE_LIST, ticketTypeService.listEnabled());
    return model;
  }

  private String seeList() {
    return new StringBuilder()
        .append(ServiceConstants.REDIRECT)
        .append(ServiceConstants.U_TICKET)
        .append(ServiceConstants.SLASH)
        .append(ServiceConstants.M_LIST)
        .toString();
  }
}
