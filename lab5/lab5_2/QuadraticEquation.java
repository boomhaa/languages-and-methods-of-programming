import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class QuadraticEquation {

    private HashMap<Integer, ArrayList<Fraction>> table;

    public QuadraticEquation(ArrayList<Fraction> fractions) {
        this.table = new HashMap<>();
        for (int i = 0; i < fractions.size() - 1; i++) {
            ArrayList<Fraction> pair = new ArrayList<>();
            pair.add(fractions.get(i));
            pair.add(fractions.get(i + 1));
            this.table.put(i, pair);
        }
    }

    int getDisc(ArrayList<Integer> koefs){
        int disc = koefs.get(1)*koefs.get(1) - 4* koefs.get(0)*koefs.get(2);
        return disc;
    }

    public int gcd(int a, int b) {
        if (a<0){
            a = -a;
        }
        if (b<0){
            b = -b;
        }
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public ArrayList<Integer> makeKoefs(ArrayList<Fraction> pair) {
        ArrayList<Integer> res = new ArrayList<>();
        int a = pair.get(0).znam * pair.get(1).znam;
        int b = -(pair.get(0).chisl*pair.get(1).znam + pair.get(1).chisl*pair.get(0).znam);
        int c = pair.get(0).chisl * pair.get(1).chisl;
        int gcd = gcd(a,gcd(b,c));
        a/=gcd;
        b/=gcd;
        c/=gcd;
        res.add(a);
        res.add(b);
        res.add(c);
        return res;
    }

    public Stream<ArrayList<Integer>> generateKoefs(){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        this.table.entrySet().stream().forEach(x->result.add(makeKoefs(x.getValue())));
        return result.stream();
    }
    public Stream<Integer> generateDics(){
        Stream<ArrayList<Integer>> koefs = generateKoefs();
        ArrayList<Integer> res = new ArrayList<>();
        koefs.forEach(x-> res.add(getDisc(x)));
        return res.stream();
    }

    public Optional<Integer> getMaxDics(){
        Stream<Integer> disc = generateDics();
        return disc.max(Integer::compareTo);
    }
}
