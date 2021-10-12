public class Conta {
  private double saldo;
  int agencia;
  int numero;
  Cliente titular;

  void deposita(double valor) {
    this.saldo = this.saldo + valor;
  }

  boolean saca(double valor) {
    if (this.saldo >= valor) {
      this.saldo = this.saldo - valor;
      return true;
    } else {
      return false;
    }
  }

  boolean transfere(double valor, Conta destino) {
    if (this.saldo >= valor) {
      this.saca(valor);
      destino.deposita(valor);
      return true;
    }
    return false;
  }

  public double getSaldo() {
    return this.saldo;
  }
}
