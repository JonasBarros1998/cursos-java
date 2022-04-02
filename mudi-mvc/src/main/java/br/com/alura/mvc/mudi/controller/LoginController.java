package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoLogin;

@Controller
public class LoginController {
  
  @GetMapping
  @RequestMapping(value="login")
  public String login() {
    return "login";
  }
}
