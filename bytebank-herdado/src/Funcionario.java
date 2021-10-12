public abstract class Funcionario {
  private String nome;
  private String cpf;
  protected double salario;

  public abstract double addBonificacao();

  public String getCpf() {
    return cpf;
  }

  public String getNome() {
    return nome;
  }

  public double getSalario() {
    return salario;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

}
