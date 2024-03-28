import java.util.Arrays;

class Vector {
    private int[] coordinates;
    private int dimension;
    public Vector(int dimension,int... coordinates) {
        this.dimension = dimension;
        this.coordinates = coordinates;
    }

    public boolean isOrthogonalTo(Vector other) {
        if (this.coordinates.length != other.coordinates.length) {
            return false;
        }

        int dotProduct = 0;
        for (int i = 0; i < coordinates.length; i++) {
            dotProduct += other.coordinates[i] * this.coordinates[i];
        }
        return dotProduct == 0;
    }

    public String toString() {
        return "Vector{ coordinates = " + Arrays.toString(coordinates) + '}';
    }
}