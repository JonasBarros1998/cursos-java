package br.com.alura.javaio;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TesteEscrita {
  public static void main(String[] args) throws IOException {
    // PrintWriter printWriter = new PrintWriter("file2.txt");
    
    PrintStream printstream = new PrintStream("file2.txt");
    printstream.println("Lorem ipsum");
    printstream.close();
  }

  public void fileWrite() {

    try {
      FileWriter fw = new FileWriter("file2.txt");
      fw.write("keyboard");
      fw.write(System.lineSeparator());
      fw.write("screm");
      fw.close();
    } catch (Exception e) {
      //ADD Exception
    }
  }


  public void outputAndWriteStream() {

    try {
      FileOutputStream fos = new FileOutputStream("file2.txt");
      OutputStreamWriter osw = new OutputStreamWriter(fos);
      BufferedWriter bw = new BufferedWriter(osw);
      bw.write("Lorem");
      bw.newLine();
      bw.write("keyboard");
      bw.close();
    
    } catch (Exception e) {
      //ADD Exception
    }

   
  }
}
