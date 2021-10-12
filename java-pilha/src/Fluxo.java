public class Fluxo {
  public static void main(String[] args) {
    System.out.println("Ini do main");
    try {
      metodo1();
    } catch (ArithmeticException | NullPointerException | MinhaExcecao ex) {
      System.out.println("Exception "+ex.getMessage());
      ex.printStackTrace();
    }
    System.out.println("Fim do main");
  }

  private static void metodo1() {
    System.out.println("Ini do metodo1");
    try {
      metodo2();
    } catch (MinhaExcecaoComExption e) {
      System.out.println("Exeção tratada como Exception");
    }
    System.out.println("Fim do metodo1");
  }

  private static void metodo2() throws MinhaExcecaoComExption {
    System.out.println("Ini do metodo2");
    throw new MinhaExcecaoComExption("deu muito errado");
    // System.out.println("Fim do metodo2");
  }
}
