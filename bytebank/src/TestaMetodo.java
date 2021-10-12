public class TestaMetodo {
  public static void main(String[] args) {
    Conta conta = new Conta();
    conta.saldo = 100;
    conta.deposita(50);
  
    Conta contaDoJonas = new Conta();
    contaDoJonas.deposita(1000);

    contaDoJonas.transfere(500, conta);

    System.out.println("conta de jonas: " + contaDoJonas.saldo);
    System.out.println("minha conta: " + conta.saldo);
  }
}
