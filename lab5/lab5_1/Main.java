import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1234);
        numbers.add(230);
        numbers.add(5678);
        numbers.add(12345);
        String pattern = "?23?";

        IntegerSet integerSet = new IntegerSet(numbers, pattern);
        integerSet.fillteredByPattern().sorted(new NameComparator()).forEach(System.out::println);
        Optional<Integer> maxNumber = integerSet.getMax();
        maxNumber.ifPresentOrElse(
                num->System.out.println("Number matching the pattern: " + num),
                () -> System.out.println("Number doesn't exist!!!")
        );
    }
}
