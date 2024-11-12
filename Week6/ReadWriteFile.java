import java.io.File;
import java.io.FileReader;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class ReadWriteFile {
    public static void main(String[] args) {
        Scanner s = null;
        String str = "Hello,1,World!,2";
        try {
            FileReader myFile = new FileReader("input.txt");

            s = new Scanner(str);
            s.useDelimiter(",");
            while(s.hasNext())
            System.out.println("Token: " + s.next());
        }
        finally {
            if(s != null)
            s.close();
        }
    }
}
