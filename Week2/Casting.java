public class Casting {
    public static void main(String[] args) {
        int i = 100;
        long l = 100L;

        l = i;
        i = l; //NOTE ERROR BC WIDENING CASTING
        i = (int) l;
        l = (long) i;
    }
}
