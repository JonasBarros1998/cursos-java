package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteSaca {
  public static void main(String[] args) {
    ContaCorrente contaCorrente = new ContaCorrente(2222, 2233);
    contaCorrente.deposita(300);
    try {
      contaCorrente.saca(400);
    } catch (SaldoInsuficienteException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
