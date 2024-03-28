import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrthogonalVectorSequence sequence = new OrthogonalVectorSequence(3);

        sequence.addVector(new Vector(3,1, 0, 0));
        sequence.addVector(new Vector(3,0, 1, 0));
        sequence.addVector(new Vector(3,1, 1, 0));
        sequence.addVector(new Vector(3,-1, 1, 0));
        sequence.addVector(new Vector(3,1, 10, 0));
        sequence.addVector(new Vector(3,8, 344, 0));


        Iterator<List<Vector>> iterator = sequence.getOrthogonalSubsequencesIterator();
        while (iterator.hasNext()) {
            List<Vector> subsequence = iterator.next();
            if (subsequence.size()>1) {
                System.out.println(subsequence);
            }
        }
    }
}