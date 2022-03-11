package com.br.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

  private String nome;

  // Entity
  private CPF cpf;

  // Value Objects
  private Email email;

  private String senha;

  // Value Objects
  private ArrayList<Telefone> telefones = new ArrayList<Telefone>(); 


  public Aluno(String nome, CPF cpf, Email email) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
  }

  public void adicionarTelefone(String ddd, String numero) {
    this.telefones.add(new Telefone(ddd, numero));
  }

  public String getNome() {
    return this.nome;
  }

  public String getCPF() {
    return this.cpf.getNumero();
  }

  public String getEmail() {
    return this.email.getEndereco();
  }

  public List<Telefone> getTelefones() {
    return this.telefones;
  }
  
}
