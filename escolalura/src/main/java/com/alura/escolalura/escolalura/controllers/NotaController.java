package com.alura.escolalura.escolalura.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.alura.escolalura.escolalura.Model.Aluno;
import com.alura.escolalura.escolalura.Model.Nota;
import com.alura.escolalura.escolalura.repositories.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotaController {

  @Autowired
  private AlunoRepository repository;
  
  @GetMapping("/nota/cadastrar/{id}")
  public String cadastrar(@PathVariable String id, Model model) {
    Aluno aluno = repository.obterAlunoPor(id);  
    model.addAttribute("aluno", aluno);
    model.addAttribute("nota", new Nota());

    return "nota/cadastrar";
  }

  @PostMapping("/nota/salvar/{id}")
  public String salvar(@PathVariable String id, @ModelAttribute Nota nota) {
    Aluno aluno = repository.obterAlunoPor(id);
    
    repository.salvar(aluno.adicionar(aluno, nota));

    return "redirect:/aluno/listar";
  }

  @GetMapping("/nota/iniciarpesquisa")
  public String iniciarPesquisa() {
    return "nota/pesquisar";
  }

  @GetMapping("/nota/pesquisar")
  public String pesquisarPor(@RequestParam("classificacao") String classificacao, @RequestParam("notacorte") String notaCorte, Model model) {
    List<Aluno> alunos = repository.pesquisarPor(classificacao, Double.parseDouble(notaCorte));
    model.addAttribute("alunos", alunos);
    return "nota/pesquisar";
  }
}