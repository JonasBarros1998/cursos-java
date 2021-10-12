public class ControleBonificacao {
  private double soma = 0;

  public void registar(Funcionario funcionario) {
    double bonificacao = funcionario.addBonificacao();
    this.soma = soma + bonificacao;
  }

  public double getSoma() {
    return this.soma;
  }
}
