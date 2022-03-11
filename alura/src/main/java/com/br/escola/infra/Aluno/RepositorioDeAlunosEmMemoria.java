package com.br.escola.infra.Aluno;

import java.util.ArrayList;
import java.util.List;

import com.br.escola.dominio.aluno.Aluno;
import com.br.escola.dominio.aluno.AlunoNaoEncontrado;
import com.br.escola.dominio.aluno.CPF;
import com.br.escola.dominio.aluno.RepositorioDeAluno;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAluno {

  private List<Aluno> matriculados = new ArrayList<Aluno>();

  @Override
  public void matricular(Aluno aluno) {
    this.matriculados.add(aluno);
    
  }

  @Override
  public Aluno buscarPorCPF(CPF cpf) {
    return this.matriculados.stream()
      .filter(a -> a.getCPF().equals(cpf.getNumero()))
      .findFirst()
      .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
  }

  @Override
  public List<Aluno> listarTodosAlunosMatriculados() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
