public class TestaBancoSemCliente {
  public static void main(String[] args) {
    Conta conta = new Conta();

    conta.deposita(400);

    conta.saca(300);

    System.out.println("Meu saldo eh " + conta.getSaldo());
  }
}
