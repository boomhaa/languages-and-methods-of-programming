import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class IntegerSet {
    private ArrayList<Integer> numbers;
    private String pattern;
    public IntegerSet(ArrayList<Integer> numbers, String pattern){
        this.numbers = numbers;
        this.pattern = pattern;
    }
    private boolean matchesPattern(int number, String pattern) {
        String numberStr = String.valueOf(number);
        if (numberStr.length()>pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(pattern.length()-i-1);
            if (i<numberStr.length()) {
                if (patternChar != '?' && patternChar != numberStr.charAt(numberStr.length()-i-1)) {
                    return false;
                }
            }else {
                if (patternChar != '?'){
                    return false;
                }
            }
        }
        return true;
    }

    public Stream<Integer> fillteredByPattern(){
        ArrayList<Integer> result = new ArrayList<>();
        numbers.stream().filter(x -> matchesPattern(x,this.pattern)).forEach(x-> result.add(x));
        return result.stream();
    }

    public Optional<Integer> getMax(){
        Stream<Integer> numbers = fillteredByPattern();
        return numbers.max(Integer::compareTo);
    }

}
