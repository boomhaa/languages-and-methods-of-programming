public class Year {
    private int year;

    public Year(int year) {
        this.year = year;
    }

    public boolean isVisokosny() {
        if (year % 400 == 0) {
            return true;
        } else if (year%100==0) {
            return false;
        } else if (year%4==0) {
            return true;
        }else {
            return false;
        }
    }
    public String toString(){
        return "Year: "+year;
    }
}
