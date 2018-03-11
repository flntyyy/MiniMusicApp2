package Figures;

public class Rectangle extends GeometricFigure {

    public Rectangle (int side1, int side2) {
        super(side1, side2);
    }

    public void perimeter() {
        int per  = (side1 + side2) * 2;
        System.out.println("Периметр прямоугольника " + per);
    }

    public void area () {
        int area = side1 * side2;
        System.out.println("Площадь прямоугольника " + area);

    }
}
