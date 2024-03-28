public class sortDS implements Comparable<sortDS>{
    private DoubleStack ds;
    private int size;
    public sortDS(int size, DoubleStack ds){
        this.ds = ds;
        this.size = size;
    }
    public int sum_of_array(DoubleStack ds,int left, int right){
        int sum = 0;
        for(int i = left;i<right;i++){
            sum += ds.arr[i];
        }
        return sum;
    }
    public String toString(){
        String res = "";
        for (int i = 0;i<this.size;i++){
            res += this.ds.arr[i] + " ";
        }
        return res;
    }
    public int compareTo(sortDS obj){
        return (sum_of_array(this.ds, 0, this.ds.top1+1) - sum_of_array(this.ds, this.ds.top2-1, this.size))-(sum_of_array(obj.ds, 0, obj.ds.top1+1) - sum_of_array(obj.ds, obj.ds.top2-1, obj.size));
    }
}
