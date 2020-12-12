import lambda.MathOperation;

public class MathOperationTask {
    public static void main(String[] args) {

        //5 + 2  - 3 * 7 + 2 /3;

        MathOperation add = ((a, b) -> a + b);
        MathOperation substract = ((a, b) -> a - b);
        MathOperation multiply = ((a, b) -> a * b);
        MathOperation devide = ((a, b) -> a / b);

        int onScreenNumber = 0;

        onScreenNumber = calculate(5, add, 2);
        onScreenNumber = calculate(onScreenNumber, substract, 3);
        onScreenNumber = calculate(onScreenNumber, multiply, 7);
        onScreenNumber = calculate(onScreenNumber, add, 2);
        onScreenNumber = calculate(onScreenNumber, devide, 3);

        System.out.println(onScreenNumber);

    }

    private static int calculate(int onScreenNumber, MathOperation mo, int enteredNumber) {

        return mo.operate(onScreenNumber, enteredNumber);
    }
}
