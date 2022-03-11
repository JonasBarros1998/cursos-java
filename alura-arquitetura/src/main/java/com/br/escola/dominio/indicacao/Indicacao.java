package com.br.escola.dominio.indicacao;

import java.time.LocalDateTime;

import com.br.escola.dominio.aluno.Aluno;

public class Indicacao {
  private Aluno indicado;
  private Aluno indicante;
  private LocalDateTime dataIndicacao;

  public Indicacao(Aluno indicado, Aluno indicante) {
    this.indicado = indicado;
    this.indicante = indicante;
    this.dataIndicacao = LocalDateTime.now();
  }

  public Aluno getIndicado() {
    return this.indicado;
  }

  public Aluno getIndicante() {
    return this.indicante;
  }

  public LocalDateTime getDataIndicacao() {
    return this.dataIndicacao;
  }
}
