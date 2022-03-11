package com.br.escola;

import com.br.escola.aplicacao.aluno.MatricularAluno;
import com.br.escola.aplicacao.aluno.MatricularAlunoDto;
import com.br.escola.infra.Aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
  public static void main(String[] args) {
    String nome = "Fulano";
    String cpf = "123.456.789-00";
    String email = "fulano@email.com";
    MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
    matricular.executa(new MatricularAlunoDto(nome, cpf, email));
    
  }
}
