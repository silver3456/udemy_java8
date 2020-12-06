import lambda.GreetingService;

public class TestFourMain {

    public static void main(String[] args) {

        String ss = getLambda().greet("data");
        System.out.println(ss);
    }

    private static void test(GreetingService g) {
        String returnString = g.greet("udemy");
        System.out.println(returnString);
    }

    private static GreetingService getLambda() {
        GreetingService g = (s) -> s.toUpperCase();
        return g;
    }
}
