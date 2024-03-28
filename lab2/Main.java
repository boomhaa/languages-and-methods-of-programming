public class Main
{

    public static void main(String [] args)
    {
        Year b = new Year(1900);
        System.out.println(b);
        System.out.println(b.isVisokosny());
        Year a = new Year(2000);
        System.out.println(a);
        System.out.println(a.isVisokosny());
        Year y = new Year(2003);
        System.out.println(y);
        System.out.println(y.isVisokosny());
        Year newYear = new Year(2024);
        System.out.println(newYear);
        System.out.println(newYear.isVisokosny());

    }
}