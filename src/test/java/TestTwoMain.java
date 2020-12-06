import lambda.GreetingService;

import java.util.ArrayList;
import java.util.List;

public class TestTwoMain {
    public static void main(String[] args) {

       List<String> list = new ArrayList<>();
       list.add("");
       list.add("alex");

        GreetingService gs1 = fn -> {
            return fn.toUpperCase() + list.get(1);
        };
        System.out.println(gs1.greet(" Alex"));

        GreetingService gs2 = fn -> {
            list.remove(1);
            return fn.toUpperCase();
        };

        System.out.println(gs1.greet(" Alex"));


    }
}
