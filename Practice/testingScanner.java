import java.util.Scanner;

public class testingScanner {
    public static void testingScanner(){
        
    }
    public static void main(String[] args) {
        Scanner s = null;
        String str = "100 200";
        int a = 0, b = 0;
        try {
        s = new Scanner(str);
        if(s.hasNextInt())
        a = s.nextInt();
        if(s.hasNextInt())
        b = s.nextInt();
        System.out.println(a*b);
        }
        finally {
        if(s != null)
        s.close();
        }
        }
}