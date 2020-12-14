import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionImprovedTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        int sum = list.stream()
                .mapToInt(a -> a)// converts wrapper type to a primitive
                .sum(); // this method becomes available

        System.out.println(sum);
    }
}
