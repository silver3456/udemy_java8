import java.util.function.Supplier;

public class Test11Main {
    public static void main(String[] args) {
//        Supplier<Double> random = () -> Math.random();

        // Another way of writing
        Supplier<Double> random = Math::random;

        System.out.println(random.get());

    }
}
