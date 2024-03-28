import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        DoubleStack arr1 = new DoubleStack(10);
        DoubleStack arr2 = new DoubleStack(9);
        DoubleStack arr3 = new DoubleStack(11);
        arr1.push1(1);
        arr1.push1(1);
        arr1.push1(1);
        arr1.push1(1);
        arr1.push1(1);
        arr1.push2(2);
        arr1.push2(2);
        arr1.push2(2);
        arr1.push2(2);
        arr1.push2(2);
        arr2.push1(7);
        arr2.push1(10);
        arr2.push1(5);
        arr2.push2(7);
        arr2.push2(10);
        arr2.push2(5);
        arr3.push1(1);
        sortDS[] a  = new sortDS[]{
                new sortDS(10,arr1),
                new sortDS(9,arr2),
                new sortDS(11,arr3)
        };
        Arrays.sort(a);
        for(sortDS s: a){
            System.out.println(s);
        }
    }

}