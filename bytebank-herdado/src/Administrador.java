public class Administrador extends Funcionario implements Autenticavel {
  
  private AutenticacaoUtil autenticar;

  public Administrador(AutenticacaoUtil autenticar) {
    this.autenticar = autenticar;
  }

  @Override
  public double addBonificacao() {
    return 50;
  }

  @Override
  public void setSenha(int senha) {
    this.autenticar.setSenha(senha);
  }

  @Override
  public boolean autentica(int senha) {
    return this.autentica(senha);
  }

}
