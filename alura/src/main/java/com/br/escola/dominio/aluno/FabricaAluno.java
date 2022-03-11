package com.br.escola.dominio.aluno;

public class FabricaAluno {
  private Aluno aluno;


  public FabricaAluno comNomeCpfEmail(String nome, String cpf, String email) {
    this.aluno = new Aluno(nome, 
        new CPF(cpf), 
        new Email(email));
    return this;
  }

  public FabricaAluno comTelefone(String ddd, String numero) {
    this.aluno.adicionarTelefone(ddd, numero);
    return this;
  }

  public Aluno criar() {
    return this.aluno;
  }
}
