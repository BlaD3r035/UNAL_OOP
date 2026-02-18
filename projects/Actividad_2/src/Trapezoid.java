public class Trapezoid {
    private int base1;
    private int base2;
    private int height;
    private int side1;
    private int side2;

    public Trapezoid(int base1, int base2, int height, int side1, int side2) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    public double calculateArea() {
        return ((base1 + base2) * height) / 2.0;
    }

    public double calculatePerimeter() {
        return base1 + base2 + side1 + side2;
    }
}

