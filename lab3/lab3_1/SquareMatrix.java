public class SquareMatrix implements Comparable<SquareMatrix>{
    private int[][] matrix;
    private  int n;
    public SquareMatrix(int n, int[][] matrix){
        this.matrix = matrix;
        this.n = n;
    }
    public int takeElem(int i, int j, int[][] matrix){
        return matrix[i][j];
    }
    public String toString(){
        String mat = "";
        for(int i = 0;i<this.n;i++){
            for(int j = 0;j<this.n;j++){
                mat+=this.matrix[i][j]+" ";
            }
            mat+="\n";
        }
        return mat;
    }
    public int countofElems(int[][] matrix){
        int cnt = 0;
        for(int i = 0;i<this.n-1;i++){
            for(int j = i+1;j<this.n;j++){
                if (takeElem(i,j,matrix)!=takeElem(j,i,matrix)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int compareTo(SquareMatrix obj){
        return countofElems(this.matrix)-countofElems(obj.matrix);
    }
}
