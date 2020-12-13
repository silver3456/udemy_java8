import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TerminalOperTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("alex");
        list.add("bob");
        list.add("david");
        list.add("john");

        /* Usage of Optional

        Optional<String> op = list.stream()
                .filter(s -> s.length() > 3)
                .findFirst();

        if (op.isPresent())
            System.out.println(op.get());

            */

        System.out.println(

//                list.stream()
//                .filter(s -> s.length() > 3)
//                .count() // counts after some changes are made inside the list


//                list.stream()
//                        .filter(s -> s.length() > 3)
//                        .findFirst() //returns Optional meaning if there is no satisfied
                //condition then it will not do anything


//                list.stream()
//                        .min(Comparator.naturalOrder())
//                        .get() // to get optional value

                list.stream()
                        .filter(s -> s.length() > 3)
                        .anyMatch(s -> s.contains("e"))


        );
    }
}
