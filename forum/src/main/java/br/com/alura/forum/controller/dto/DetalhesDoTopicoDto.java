package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Resposta;
import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;

public class DetalhesDoTopicoDto {
  private Long id; 
  private String titulo; 
  private String mensagem; 
  private LocalDateTime dataCriacao;
  private String nomeAutor;
  private StatusTopico statusTopico;
  private List<RespostaDto> respostas;

  public DetalhesDoTopicoDto(Topico topico) {
    this.titulo = topico.getTitulo();
    this.statusTopico = topico.getStatus();
    this.id = topico.getId();
    this.mensagem = topico.getMensagem();
    this.dataCriacao = topico.getDataCriacao();
    this.nomeAutor = topico.getAutor().getNome();
    this.respostas = new ArrayList<>();
    this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
  }

  public List<RespostaDto> getRespostas() {
    return respostas;
  }

  public void setRespostas(List<RespostaDto> respostas) {
    this.respostas = respostas;
  }

  public StatusTopico getStatusTopico() {
    return statusTopico;
  }

  public void setStatusTopico(StatusTopico statusTopico) {
    this.statusTopico = statusTopico;
  }

  public String getNomeAutor() {
    return nomeAutor;
  }

  public void setNomeAutor(String nomeAutor) {
    this.nomeAutor = nomeAutor;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }




}