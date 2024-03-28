import java.util.*;

public class Digit {

    private int digit;
    private int poweroftwo;

    public Digit(int digit) {
        this.digit = digit;

        this.poweroftwo = (int)(Math.log(digit) / Math.log(2)) + 1;
    }
    public List<Integer> toBinary(int number){
        List<Integer> binary = new ArrayList<>();
        while(number>0){
            binary.add(number%2);
            number/=2;
        }
        Collections.reverse(binary);
        return binary;
    }
    public String toString(){
        String res = "";
        List<Integer> binary = toBinary(this.digit);
        for (int i = 0; i<binary.size();i++){
            res+=binary.get(i);
        }
        return res;
    }
    public Iterator<Integer> getBitsIterator() {
        return new BitsIterator();
    }
    private class BitsIterator implements Iterator<Integer> {
        private int curId = 0;

        public boolean hasNext() {
            return digit != 0;
        }

        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            while (digit > 0 && digit % 2 == 0) {
                curId++;
                digit /= 2;
            }
            if (digit % 2 == 1) {
                curId++;
                digit /= 2;
            }
            return poweroftwo - curId + 1;
        }
    }
}
