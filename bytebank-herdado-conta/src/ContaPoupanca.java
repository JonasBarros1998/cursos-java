public class ContaPoupanca extends Conta {

  public ContaPoupanca(int agencia, int numero) {
    super(agencia, numero);
  }

  @Override
  public void saca(double valor) throws SaldoInsuficienteException {
    double valorASacar = valor += 0.20;
    super.saca(valorASacar);
  }
}
