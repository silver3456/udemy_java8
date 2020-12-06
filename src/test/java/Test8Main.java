import lambda.StringOperations;

import java.util.ArrayList;
import java.util.List;

public class Test8Main {

    public static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        StringOperations op1 = list::add;
        op1.accept("udemy");

        System.out.println(list);
    }
}
