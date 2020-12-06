import lambda.GreetingService;

public class TestThreeMain {
    public static void main(String[] args) {
//
//        test(n -> n.toUpperCase());
//        test(n -> n.toLowerCase());
//        test(n -> n.length() + "");

        System.out.println("starting execution");

        test(s -> {
            System.out.println("inside lambda");
            return s.toUpperCase();
        });

        System.out.println("ending execution");

    }

    private static int getNumber() {
        System.out.println("called getNumber()");
        return 5;
    }

    private static void receiveNumber(int i) {
        System.out.println("Received number is:: " + i);
    }

    private static void test(GreetingService g) {
        String returnString = g.greet("udemy");
        System.out.println(returnString);
    }
}
