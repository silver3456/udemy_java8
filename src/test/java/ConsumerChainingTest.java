import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerChainingTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("alex");
        list.add("silver");

        Consumer<String> dbConsumer = (s) -> {
            System.out.println("writing in DB :: " + s);
        };

        Consumer<String> loggingConsumer = (s) -> {
            System.out.println("writing into log file :: " + s);
        };

        Consumer<String> dbLogConsumer = dbConsumer.andThen(loggingConsumer);


        BiConsumer<String, Integer> biConsumer = (s, i) -> {
            System.out.println("My name is : " + s);
            System.out.println("My age is : " + i);

        };

        biConsumer.accept("udemy", 10);





        Map<String, Consumer<String>> map = new HashMap<>();

        map.put("db", dbConsumer);
        map.put("log", loggingConsumer);
        map.put("dblog", dbLogConsumer);

        map.forEach((k, v) -> {
            System.out.println("Key is : " + k);
        });


//        list.forEach(map.get(System.getProperty("consumer-type")));

    }
}
