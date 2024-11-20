public class execTime{
    private static long sum() {
        Long sum = 0L;
        for(long i = 0; i <= Integer.MAX_VALUE; i++) {
        sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        sum();
        long end = System.currentTimeMillis();
        System.out.println("sum() took: " + (end-start) + " ms");
    }
}