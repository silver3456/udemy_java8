import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test12Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("alex");
        list.add("silver");

//        Consumer<String> c1 = (s) -> System.out.println(s);
//        list.forEach(c1);

        //another way
        list.forEach(s -> System.out.println(s.toUpperCase()));



    }
}
