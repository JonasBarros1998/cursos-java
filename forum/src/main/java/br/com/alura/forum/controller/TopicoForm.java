package br.com.alura.forum.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;

public class TopicoForm {

  @NotNull @NotEmpty
  private String titulo;
  @NotNull @NotEmpty
  private String mensagem;
  
  @NotNull @NotEmpty
  private String nomeCurso;

  public String getTitulo() {
    return titulo;
  }
  public String getNomeCurso() {
    return nomeCurso;
  }

  public void setNomeCurso(String nomeCurso) {
    this.nomeCurso = nomeCurso;
  }
  public String getMensagem() {
    return mensagem;
  }
  
  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public Topico converter(CursoRepository cursoRepository) {
    Curso curso = cursoRepository.findByNome(this.nomeCurso);
    return new Topico(this.titulo, this.mensagem, curso);
  }

  
}
