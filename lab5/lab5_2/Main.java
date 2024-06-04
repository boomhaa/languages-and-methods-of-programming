import java.util.ArrayList;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(7, 3);
        Fraction c = new Fraction(5, 4);
        ArrayList<Fraction> posl = new ArrayList<>();
        posl.add(c);
        posl.add(b);
        posl.add(a);
        QuadraticEquation equation = new QuadraticEquation(posl);
        equation.generateKoefs().sorted(new SumComparator()).forEach(System.out::println);
        Optional<Integer> maxNumber = equation.getMaxDics();
        maxNumber.ifPresentOrElse(
                num->System.out.println("Max discriminant among all: " + num),
                () -> System.out.println("Number doesn't exist!!!")
        );
    }
}
