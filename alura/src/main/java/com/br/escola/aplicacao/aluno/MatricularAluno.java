package com.br.escola.aplicacao.aluno;

import com.br.escola.dominio.aluno.Aluno;
import com.br.escola.dominio.aluno.RepositorioDeAluno;

public class MatricularAluno {
  private final RepositorioDeAluno repositorio;

  public MatricularAluno(RepositorioDeAluno repositorio) {
    this.repositorio = repositorio;
  }

  //METODO MATRICULAR Pattern COMMAND
  public void executa(MatricularAlunoDto matricularAlunoDto) {
    Aluno novo = matricularAlunoDto.criarAluno();
    repositorio.matricular(novo);

  }
}
