import java.util.Scanner;

public class Ej2_4_pg86 {
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter circle radius: ");
        int circleRadius = sc.nextInt();
        Circle figure1 = new Circle(circleRadius);

        System.out.println("Enter rectangle width: ");
        int rectWidth = sc.nextInt();
        System.out.println("Enter rectangle height: ");
        int rectHeight = sc.nextInt();
        Rectangle figure2 = new Rectangle(rectWidth, rectHeight);

        System.out.println("Enter square side: ");
        int squareSide = sc.nextInt();
        square figure3 = new square(squareSide);

        System.out.println("Enter right triangle base: ");
        int triangleBase = sc.nextInt();
        System.out.println("Enter right triangle height: ");
        int triangleHeight = sc.nextInt();
        RightTriangle figure4 = new RightTriangle(triangleBase, triangleHeight);

        System.out.println("Enter rhombus diagonal 1: ");
        int rhombusDiag1 = sc.nextInt();
        System.out.println("Enter rhombus diagonal 2: ");
        int rhombusDiag2 = sc.nextInt();
        System.out.println("Enter rhombus side: ");
        int rhombusSide = sc.nextInt();
        Rhombus figure5 = new Rhombus(rhombusDiag1, rhombusDiag2, rhombusSide);

        System.out.println("Enter trapezium base 1: ");
        int trapBase1 = sc.nextInt();
        System.out.println("Enter trapezium base 2: ");
        int trapBase2 = sc.nextInt();
        System.out.println("Enter trapezium height: ");
        int trapHeight = sc.nextInt();
        System.out.println("Enter trapezium side 1: ");
        int trapSide1 = sc.nextInt();
        System.out.println("Enter trapezium side 2: ");
        int trapSide2 = sc.nextInt();
        Trapezoid figure6 = new Trapezoid(trapBase1, trapBase2, trapHeight, trapSide1, trapSide2);

        System.out.println();
        System.out.println("Circle area = " + figure1.calculateArea());
        System.out.println("Circle circumference = " + figure1.calculateCircumference());
        System.out.println();

        System.out.println("Rectangle area = " + figure2.calculateArea());
        System.out.println("Rectangle perimeter = " + figure2.calculatePerimeter());
        System.out.println();

        System.out.println("Square area = " + figure3.calculateArea());
        System.out.println("Square perimeter = " + figure3.calculatePerimeter());
        System.out.println();

        System.out.println("Right triangle area = " + figure4.calculateArea());
        System.out.println("Right triangle perimeter = " + figure4.calculatePerimeter());
        figure4.typeOfTriangle();
        System.out.println();

        System.out.println("Rhombus area = " + figure5.calculateArea());
        System.out.println("Rhombus perimeter = " + figure5.calculatePerimeter());
        System.out.println();

        System.out.println("Trapezium area = " + figure6.calculateArea());
        System.out.println("Trapezium perimeter = " + figure6.calculatePerimeter());

        sc.close();
    }
}
