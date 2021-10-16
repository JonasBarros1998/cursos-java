package br.com.bytebank.banco.contaespecial;

import br.com.bytebank.banco.modelo.ContaCorrente;
/**
 * Classes de conta especial
 * @author Jonas
 * @deprecated
 * @version 1.1
 */
public class ContaEspecial extends ContaCorrente {
  public ContaEspecial(int agencia, int conta) {
    super(agencia, conta);
    System.out.println(super.saldoDaContaCorrente);
  }
}
