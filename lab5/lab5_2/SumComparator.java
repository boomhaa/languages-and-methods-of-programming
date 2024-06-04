import java.util.*;

class SumComparator implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        int a0 = 0, b0 = 0;
        for (int elem: a){
            a0+=elem;
        }
        for (int elem: b){
            b0+=elem;
        }
        if (a0 > b0) {
            return 1;
        }
        if (a0 == b0) {
            return 0;
        }
        return -1;
    }
}