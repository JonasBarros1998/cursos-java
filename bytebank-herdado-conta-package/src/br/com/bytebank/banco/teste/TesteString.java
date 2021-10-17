package br.com.bytebank.banco.teste;

public class TesteString {
  public static void main(String[] args) {
    String nome = "Alura";
    System.out.println(nome);
    String stringVazia = "   ";

    String string = new String("JONAS");
    System.out.println(string);

    System.out.println(nome.charAt(1));
    System.out.println(nome.indexOf("ur"));
    System.out.println(stringVazia.isBlank());
    System.out.println(nome.isEmpty());

  }
}
