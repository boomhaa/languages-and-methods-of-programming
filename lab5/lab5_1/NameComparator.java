import java.util.*;

class NameComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        String a0, b0;
        a0 = String.valueOf(a);
        b0 = String.valueOf(b);
        if (a0.length() > b0.length()) {
            return 1;
        }
        if (a0 == b0) {
            return 0;
        }
        return -1;
    }
}