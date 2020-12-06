import lambda.MathOperation;

public class Assignment1 {

    public static void main(String[] args) {
        int addRes = calculate((a, b) -> a + b);
        System.out.println("Add result: " + addRes);

        int substracRes = calculate((a, b) -> a - b);
        System.out.println("Substract result: " + substracRes);

        int multiplyRes = calculate((a, b) -> a * b);
        System.out.println("Multiply result: " + multiplyRes);

        int divideRes = calculate((a, b) -> a / b);
        System.out.println("Division result: " + divideRes);
    }

    private static int calculate(MathOperation mop) {
        int a = 100;
        int b = 5;
        return mop.operate(a, b);
    }
}
