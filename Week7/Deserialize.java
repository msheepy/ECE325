package Week7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Deserialize {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = null;
        FileOutputStream oos = null;
        CarCopy car = new CarCopy();
        car.setMaxSpeed(100);
        try {
            oos = new FileOutputStream("output.txt");
            out = new ObjectOutputStream(oos);
            out.writeObject(car);
        }
        finally {
            if(oos != null) oos.close();
            if(out != null) out.close();
        }
        }
}
