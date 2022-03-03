import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;

public class TesteEscrite {
  public static void main(String[] args) throws FileNotFoundException {
    FileOutputStream fos = new FileOutputStream("file2.txt");
    OutputStreamWriter osw = new OutputStreamWriter(fos);
    
  }
}
