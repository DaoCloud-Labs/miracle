package io.daocloud.miracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping("/")
  public String one(){
    return "index_a.html";
  }

  @RequestMapping("/another")
  public String two(){
    return "index_b.html";
  }
}
