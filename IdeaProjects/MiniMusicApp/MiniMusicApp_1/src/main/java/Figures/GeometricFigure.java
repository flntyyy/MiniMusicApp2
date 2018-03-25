package Figures;


public abstract class GeometricFigure {

    public GeometricFigure(int radius) {
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(2,3,4);
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(2,7);
        triangle.perimeter();
        square.perimeter();
        square.area();
        rectangle.area();
        rectangle.perimeter();


    }

    public int radius;
    public int side1;
    public int side2;
    public int side3;
    public int side4;



    public GeometricFigure (int side1) {
        this.side1 = side1;
    }

    public GeometricFigure (int side1,int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public GeometricFigure (int side1,int side2,int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public GeometricFigure (int side1,int side2,int side3,int side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }



    public abstract void perimeter ();
    public abstract void area ();

}





