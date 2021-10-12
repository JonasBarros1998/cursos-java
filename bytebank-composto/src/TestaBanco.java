public class TestaBanco {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.nome = "Jonas";
        cliente.cpf = "222.222.222.22";
        cliente.profissao = "desenvolvedor";

        
        Conta conta = new Conta();
        conta.deposita(300);
        conta.titular = cliente;

        System.out.println("Nome do titular "+ conta.titular.nome);
    }
}
