package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;

class TesteObject {
  public static void main(String[] args) {
  }

  public String call() {
    ContaCorrente conta = new ContaCorrente(222, 2222);
    this.qualquerReferencia(conta);
    return "";
  }

  public void qualquerReferencia(Object referencia) {

  }
}