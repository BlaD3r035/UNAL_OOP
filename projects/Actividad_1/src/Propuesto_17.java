import java.util.Scanner;

// Dado el radio de un círculo. Haga un algoritmo que obtenga el área del círculo y la longitud
//de la circunferencia.
public class Propuesto_17 {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el radio del circulo:");
        float radius = Float.parseFloat(sc.nextLine());
        float area = circle_area(radius);
        float perimeter =  circle_perimeter(radius);
        System.out.println("Radio del circulo: "+radius);
        System.out.println("Area del circulo: " + area);
        System.out.println("Perimetro del circulo: " + perimeter);

    }
    private static float circle_area(float radius){
        return (float) (Math.PI * Math.pow(radius, 2));
    }
    private static float circle_perimeter(float radius){
        return (float) (2 * Math.PI * radius);
    }
}
