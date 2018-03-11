package Figures;

public class Triangle extends GeometricFigure {
    public Triangle(int side1, int side2, int side3) {
        super(side1, side2, side3);
    }

        public void perimeter() {
            int per  = side1 + side2 + side3;
            System.out.println("Периметр треугольника " + per);
        }

        public void area(){


        }
    }
