package br.com.alura.javaio;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeitura {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new File("contas.csv"));

    // do {
    //   System.out.println(scanner.nextLine());
    // } while (scanner.hasNextLine() == true); 

    while (scanner.hasNextLine() == true) {
      // System.out.println(scanner.nextLine());
      String line = scanner.nextLine();

      Scanner scannerLine = new Scanner(line);
      scannerLine.useDelimiter(",");
      scannerLine.useLocale(Locale.US);

      String valor1 = scannerLine.next();
      int valor2 = scannerLine.nextInt();
      int valor3 = scannerLine.nextInt();
      String valor4 = scannerLine.next();
      double valor5 = scannerLine.nextDouble();

      String format = String.format(new Locale("pt", "BR") ,"%s %s %s", valor1, valor2, valor4);
      System.out.println(format);
      scannerLine.close();

      // String[] oneLine = line.split(",");
      // System.out.println(Arrays.toString(oneLine));
      // System.out.println(oneLine[3]);
    }
    //System.out.println(scanner.nextLine());
    scanner.close();
  }
}
