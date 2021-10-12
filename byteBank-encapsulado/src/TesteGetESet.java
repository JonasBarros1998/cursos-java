public class TesteGetESet {
  public static void main(String[] args) {
    Conta conta = new Conta(1234, 78897);

    conta.deposita(400);
    conta.setTitular(new Cliente());

    conta.getTitular().setNome("JONAS");
    System.out.println("meu nome "+conta.getTitular().getNome());
  }
}
