package com.gsdd.knowledgedb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gsdd.knowledgedb.constants.ServiceConstants;

@Controller
public class IndexController {

  @GetMapping(ServiceConstants.U_INDEX)
  public String index(Model model) {
    return ServiceConstants.INDEX;
  }
}
