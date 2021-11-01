package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import java.util.ArrayList;


public class TesteArrayListEquals {
  public static void main(String[] args) {
    ArrayList<ContaCorrente> arrayList = new ArrayList<ContaCorrente>();

    ContaCorrente cc1 = new ContaCorrente(22, 33);
    arrayList.add(cc1);
    ContaCorrente cc2 = new ContaCorrente(22, 34);
    arrayList.add(cc2);
    ContaCorrente cc3 = new ContaCorrente(22, 38);
    
    boolean contemNumeroDaConta = arrayList.contains(cc3);
    System.out.println(contemNumeroDaConta);

    // for (ContaCorrente conta : arrayList ) {
    //   System.out.println(contemConta);
    // }
    
  }
}
