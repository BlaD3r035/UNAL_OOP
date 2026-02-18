public class Rhombus {
    private int diagonal1;
    private int diagonal2;
    private int side;

    public Rhombus(int diagonal1, int diagonal2, int side) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.side = side;
    }

    public double calculateArea() {
        return (diagonal1 * diagonal2) / 2.0;
    }

    public double calculatePerimeter() {
        return 4 * side;
    }
}
