import java.util.*;

public class Sort {


    public static void main(String[] args) {
        Set<String> list = new TreeSet<>();
        for (int i = 100; i > 0; i--) {
            list.add("User" + (int) (Math.random() *100));
        }
        for (String s: list) {
            System.out.println(s);
        }
    }
}
