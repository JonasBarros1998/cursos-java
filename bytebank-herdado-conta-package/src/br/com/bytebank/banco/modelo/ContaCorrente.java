package br.com.bytebank.banco.modelo;

public class ContaCorrente extends Conta implements Tributavel {

  protected int saldoDaContaCorrente;

  public ContaCorrente(int agencia, int numero) {
    super(agencia, numero);
    this.saldoDaContaCorrente = 200;
  }

  @Override
  public void getValorImposto() throws SaldoInsuficienteException {
    double imposto = super.getSaldo() * 0.1;
    super.saca(imposto);
  }

  @Override
  public void saca(double valor) throws SaldoInsuficienteException {
    double imposto = super.getSaldo() * 0.20;
    double valorAhSacar = valor + imposto;
    super.saca(valorAhSacar);
  }
  
}
