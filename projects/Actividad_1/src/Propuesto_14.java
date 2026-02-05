import java.util.Scanner;
//Elabore un algoritmo que lea un número y obtenga su cuadrado y su cubo.
public class Propuesto_14 {

    public static void run() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa un numero: ");
        int number = Integer.parseInt(sc.nextLine());

        int square = square(number);
        int cube = cube(number);
        System.out.println("Numero original: " + number);
        System.out.println("cuadrado: " + square);
        System.out.println("Cubo: " + cube);
    }
    private static int square(int number) {
        return (number*number);
    }
    private static int cube(int number) {
        return (number*number*number);
    }
}
