import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

//        for (int i = 0; i< 10; i++)
//            System.out.println("Hello world :: " + i );

          //another way of doing the operation above

        IntStream.range(1, 10)
                .forEach(i -> System.out.println("Hello world: " + i));
    }
}
