public class Main {

    public static void main(String[] args) {

        Point PointA = new Point("A");
        System.out.println("Имя точки:"+PointA.getName());


        try {
            PointA.setCoord(1.0,1.0,1.0);
            System.out.println("Длинна радиус-вектора:"+PointA.getR());
        }
        catch(myCustomException qqq)
        {
            qqq.getMsg("Точка улетела за грань нашего понимания,\nа точнее решила посетить отрицательные координаты!!!");
        }

    }
}