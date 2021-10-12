package br.com.bytebank.banco.modelo;

public interface Tributavel {
  public void getValorImposto() throws SaldoInsuficienteException; 
}
