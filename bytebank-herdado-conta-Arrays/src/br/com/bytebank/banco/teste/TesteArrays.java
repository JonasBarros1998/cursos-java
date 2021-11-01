package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;

class TesteArrays {
  public static void main(String[] args) {
    ContaCorrente[] conta = new ContaCorrente[5];
    conta[0] = new ContaCorrente(222, 2222);
    conta[1] = new ContaCorrente(333, 3333);

    System.out.println(conta[1]);

  }
}