public class TesteReferencias {
  public static void main(String[] args) {
    Conta conta = new Conta();
    conta.saldo = 300;
    System.out.println("primeira conta " + conta.saldo);

    Conta segundaConta = conta;

    System.out.println("segunda conta " + segundaConta.saldo);
    System.out.println();
  }
}
