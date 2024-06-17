//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);
        Matrix multy = m1.multiply(m2);
        Matrix add = m1.add(m2);
        multy.printMatrix();

        add.printMatrix();


    }
}