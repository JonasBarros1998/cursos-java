package br.com.bytebank.banco.teste;

import java.util.LinkedList;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class ExampleLinkedList {
  public static void main(String[] args) {
    ContaCorrente cc1 = new ContaCorrente(222, 333);
    ContaCorrente cc2 = new ContaCorrente(222, 333);
    LinkedList<ContaCorrente> arrayList = new LinkedList<ContaCorrente>();
    arrayList.add(cc1);
    arrayList.add(cc2);
  }
}
