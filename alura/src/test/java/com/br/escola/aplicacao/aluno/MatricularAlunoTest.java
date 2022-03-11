package com.br.escola.aplicacao.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.br.escola.dominio.aluno.Aluno;
import com.br.escola.dominio.aluno.CPF;
import com.br.escola.infra.Aluno.RepositorioDeAlunosEmMemoria;

import org.junit.jupiter.api.Test;

public class MatricularAlunoTest {

  @Test
  void alunoDeveriaSerPersistido() {
    RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
    MatricularAluno useCase = new MatricularAluno(repositorio);
    useCase.executa(new MatricularAlunoDto("Fulano", 
                                "123.456.789-00",
                                "fulano@gmail.com"));
    
    Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));
    assertEquals("Fulano", encontrado.getNome());
    assertEquals("123.456.789-00", encontrado.getCPF());
    assertEquals("fulano@gmail.com", encontrado.getEmail());

  }
}
