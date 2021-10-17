package br.com.bytebank.banco.modelo;

public class CalcularImposto {

  private double totalImposto;

  public void registra(Tributavel t) {
    this.totalImposto += 0.10;
  }

  public double getTotalImposto() {
    return totalImposto;
  }
  
}
