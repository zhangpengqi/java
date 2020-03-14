package basic;

interface Calc {
    int handle(int a, int b);
}


public class Demo {

    public static int test(Calc calc) {
        return calc.handle(1, 3);
    }

    public static void main(String[] args) {

        int val = Demo.test((int a, int b) -> {
            return a + b;
        });

        System.out.println(val);
    }
}






