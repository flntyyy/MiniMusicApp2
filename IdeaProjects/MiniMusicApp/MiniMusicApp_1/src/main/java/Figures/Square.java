package Figures;

public class Square extends GeometricFigure {
    public Square (int side1) {
        super(side1);
    }

    public void perimeter() {
        int per  = side1  * 4;
        System.out.println("Периметр квадрата " + per);
    }

    public void area () {
        int area = side1 * side1;
        System.out.println("Площадь квадрата " + area);

    }
}
