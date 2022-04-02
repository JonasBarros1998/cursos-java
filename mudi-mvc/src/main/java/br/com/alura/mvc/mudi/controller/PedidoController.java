package br.com.alura.mvc.mudi.controller;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private UserRepository userRepository;
  
  @RequestMapping(method = RequestMethod.GET, value="formulario")
  public String formulario(RequisicaoNovoPedido requisicao) {
    return "pedido/formulario";
  }

  @PostMapping("novo")
  public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
    
    if (result.hasErrors()) {
      return "pedido/formulario";
    }

    String username = SecurityContextHolder.getContext().getAuthentication().getName();

    Pedido pedido = requisicao.toPedido();
    User user = this.userRepository.findByUsername(username);

    pedido.setUser(user);
    pedidoRepository.save(pedido);

    return "redirect:/home";
  }
}
