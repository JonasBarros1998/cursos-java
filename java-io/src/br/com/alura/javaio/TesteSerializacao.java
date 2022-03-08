package br.com.alura.javaio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TesteSerializacao {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.bin"));
    Object nome = ois.readObject();
    System.out.println(nome);
    ois.close();
  }

  public void outputStream() throws IOException {
    String nome = "Jonas";
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.bin"));
    oos.writeObject(nome);
    oos.close();
  }
}
