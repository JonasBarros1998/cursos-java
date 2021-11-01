package br.com.bytebank.banco.teste;

import java.util.*;


public class Autoboxing {
  public static void main(String[] args) {

    //Array de tipos primitivos
    int[] idades = new int[5];
    String[] nomes = new String[5];

    //Array de referencias
    int idade = 29;//Integer

    //Forma correta de adicionar um primitivo como referencia
    Integer idadeRef = Integer.valueOf(29);
    
    //Converter uma string para primitivo
    Integer converter = Integer.valueOf("28");
    System.out.println(converter);

    //Outra forma de converter string para int. Utilize dessa maneira 
    int converter2 = Integer.parseInt("300");
    System.out.println(converter2);

    List<Integer> numeros = new ArrayList<Integer>();
    numeros.add(29);

    List<Object> referencias = new ArrayList<Object>();
    referencias.add(Double.valueOf(30.9));
  }
}
