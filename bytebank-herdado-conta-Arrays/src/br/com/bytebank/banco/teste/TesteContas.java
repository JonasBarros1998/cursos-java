package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteContas {
  public static void main(String[] args) {

    // ContaPoupanca contaPoupanca = new ContaPoupanca(333, 334455);
    // contaPoupanca.deposita(300);
    // contaPoupanca.saca(200);


    ContaCorrente contaCorrente = new ContaCorrente(333, 3333);
    contaCorrente.deposita(200);
    CalcularImposto calcularImposto = new CalcularImposto();
    calcularImposto.registra(contaCorrente);
    System.out.println(contaCorrente.getSaldo());

  }
}
