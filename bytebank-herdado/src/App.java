public class App {
    public static void main(String[] args) throws Exception {
        Gerente gerente = new Gerente();

        gerente.setNome("Jonas");
        gerente.getNome();
        gerente.setSalario(5000);

        gerente.addBonificacao();

        System.out.println("Meu salario" + gerente.getSalario());

    }
}
