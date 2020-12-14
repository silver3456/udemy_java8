import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalClassTest {

    public static void main(String[] args) {

        String a = "Ball";
        String b = "Delta";
        String c = "Apple";

        Optional<String> smallest = getSmallest(a, b, c);

        if (smallest.isPresent()) {
            System.out.println(smallest.get().toUpperCase());
        } else {
            System.out.println("No value found");
        }


    }

//    //Use Optional in case the func return null, so it will not throw
//    //NullPointException when we want to use the returned value
//    private static Optional<String> getSmallest(String var1, String var2, String var3) {
//
//        return Optional.ofNullable(null);
//    }

    private static Optional<String> getSmallest(String var1, String var2, String var3) {

        return Stream.of(var1, var2, var3)
                .min(Comparator.naturalOrder());
    }

}
