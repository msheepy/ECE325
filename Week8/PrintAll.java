
public class PrintAll {
    public static void printAll(List<? extends Number> list) {
        for(Number n : list) {
        System.out.println(n);
        }
        }
}
