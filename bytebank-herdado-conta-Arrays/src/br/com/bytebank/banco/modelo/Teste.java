package br.com.bytebank.banco.modelo;

import java.util.ArrayList;

public class Teste {
  public static void main(String[] args) {
    ArrayList<Conta> arrayList = new ArrayList<Conta>();
    ContaCorrente cc1 = new ContaCorrente(22, 33);

    //Passando o tamanho total da lista de elementos
    ArrayList<String> estados = new ArrayList<String>(26);

    arrayList.add(cc1);

    ContaCorrente cc2 = new ContaCorrente(55, 77);
    arrayList.add(cc2);

    System.out.println("tamanho do array >>>" + arrayList.size());


    for (Conta conta : arrayList) {
      System.out.println(conta.getNumero());
    }

  }
}
