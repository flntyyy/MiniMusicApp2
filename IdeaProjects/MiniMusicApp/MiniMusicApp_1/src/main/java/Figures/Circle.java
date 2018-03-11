package Figures;

public class Circle extends GeometricFigure {

    public Circle (int radius) {
        super(radius);
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
