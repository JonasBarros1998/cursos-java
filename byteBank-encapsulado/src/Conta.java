public class Conta {
  private double saldo;
  private int agencia;
  private int numero;
  private Cliente titular;
  private static int total;

  public Conta(int agencia, int numero) {
    Conta.total++;
    this.agencia = agencia;
    this.numero = numero;
  }

  public void deposita(double valor) {
    this.saldo = this.saldo + valor;
  }

  public boolean saca(double valor) {
    if (this.saldo >= valor) {
      this.saldo = this.saldo - valor;
      return true;
    } else {
      return false;
    }
  }

  public boolean transfere(double valor, Conta destino) {
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

  public double getNumero() {
    return this.numero;
  }

  public void setNumero(int novoNumero) {
    this.numero = novoNumero;
  }

  public int getAgencia() {
    return this.agencia;
  }

  public void setAgencia(int agencia) {
    this.agencia = agencia;
  } 

  public void setTitular(Cliente titular) {
    this.titular = titular;
  }

  public Cliente getTitular() {
    return titular;
  }

  public static int getTotal() {
    return Conta.total;
  }

}
