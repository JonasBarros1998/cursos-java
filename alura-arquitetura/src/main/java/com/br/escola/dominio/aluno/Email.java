package com.br.escola.dominio.aluno;

public class Email {
  private String endereco;

  public Email(String endereco) {
    this.endereco = endereco;

    if (endereco == null || 
      !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        throw new IllegalArgumentException("Email invalido");
      }
  }

  public String getEndereco() {
    return this.endereco;
  }

}
