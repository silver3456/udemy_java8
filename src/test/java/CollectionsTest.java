import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CollectionsTest {

    // This is bad approach cause during adding numbers
    // the primitive type will be converting into wrapper
    // and then back to primitive. It is very time consuming

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        Optional<Integer> reduce = list.stream()
                .reduce((a, b) -> a + b);// reduce combines everything into
                                         // a single object based on the implementation provided

        System.out.println(reduce.get());
    }
}
