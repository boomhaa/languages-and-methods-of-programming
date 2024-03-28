import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrthogonalVectorSequence {

    private List<Vector> vectors;


    public OrthogonalVectorSequence(int dimension) {

        vectors = new ArrayList<>();
    }

    public void addVector(Vector vector) {
        vectors.add(vector);
    }

    public Iterator<List<Vector>> getOrthogonalSubsequencesIterator() {
        return new OrthogonalSubsequencesIterator();
    }

    private class OrthogonalSubsequencesIterator implements Iterator<List<Vector>> {
        private int currentIndex = 0;


        public boolean hasNext() {
            return currentIndex < vectors.size();
        }


        public List<Vector> next() {
            if (!hasNext()) {
                return null;
            }

            List<Vector> subsequence = new ArrayList<>();
            subsequence.add(vectors.get(currentIndex));
            int nextIndex = currentIndex + 1;

            while (nextIndex < vectors.size() && vectors.get(nextIndex).isOrthogonalTo(subsequence.get(subsequence.size() - 1))) {
                subsequence.add(vectors.get(nextIndex));
                nextIndex++;
            }

            currentIndex = nextIndex;
            return subsequence;
        }
    }
}

