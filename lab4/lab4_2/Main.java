import java.util.*;

public class Main {

    public static void main(String[] args) {
        Digit number = new Digit(2114);
        Digit number2 = new Digit(152);
        Iterator<Integer> iterator = number.getBitsIterator();
        Iterator<Integer> iterator2 = number2.getBitsIterator();
        System.out.println(number);
        while (iterator.hasNext()) {
            int BitIndex = iterator.next();
            System.out.println(BitIndex);
        }
        System.out.println();
        System.out.println(number2);
        while (iterator2.hasNext()) {
            int BitIndex = iterator2.next();
            System.out.println(BitIndex);
        }
    }

}