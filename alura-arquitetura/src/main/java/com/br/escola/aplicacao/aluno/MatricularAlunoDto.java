package com.br.escola.aplicacao.aluno;

import com.br.escola.dominio.aluno.Aluno;
import com.br.escola.dominio.aluno.CPF;
import com.br.escola.dominio.aluno.Email;

public class MatricularAlunoDto {
  private String nomeAluno;
  private String cpfAluno;
  private String emailAluno;

  public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
    this.nomeAluno = nomeAluno;
    this.cpfAluno = cpfAluno;
    this.emailAluno = emailAluno;
  }

  public Aluno criarAluno() {
    return new Aluno(
              this.nomeAluno, 
              new CPF(this.cpfAluno), 
              new Email(this.emailAluno));
  }

}
