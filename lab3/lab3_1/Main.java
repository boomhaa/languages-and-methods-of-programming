import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr1 = {{1,1,2},{50,1,200},{100,1,1}};
        int[][] arr2 = {{1,1,2},{1,1,2},{1,1,1}};
        int[][] arr3 = {{1,1,2},{1,1,3},{2,3,1}};
        SquareMatrix[] a = new SquareMatrix[] {
                new SquareMatrix(3,  arr1),
                new SquareMatrix(3,arr2),
                new SquareMatrix(3, arr3)
        };
    Arrays.sort(a);
    for (SquareMatrix s: a){
        System.out.println(s);
    }
    }

}