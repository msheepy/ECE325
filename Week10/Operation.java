public enum Operation {
    PLUS, MINUS;
    public double apply(double x, double y) {
        switch(this) {
            case PLUS:
            return x + y;
            case MINUS:
            return x - y;
        }
        throw new AssertionError("Unknown op");
    }
    public static void main(String[] args) {
        Operation op = Operation.PLUS;
        double n = op.apply(1,1);
        String s = Double.toString(n);
        System.out.println(s);
    }
}