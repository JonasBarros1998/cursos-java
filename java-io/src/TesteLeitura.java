import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {
  public static void main(String[] args) throws IOException {

      FileInputStream fis = new FileInputStream("file.txt");
      InputStreamReader isr = new InputStreamReader(fis);
      BufferedReader br = new BufferedReader(isr);
      String line = br.readLine();
      System.out.println(line);
    }
  }
