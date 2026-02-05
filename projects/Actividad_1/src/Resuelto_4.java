import java.util.Scanner;

public class Resuelto_4 {

    public static void run(){
        Scanner sc = new Scanner(System.in);
        // Por fines practicos no se va a verificar el tipo de dato, Exepcion es manejada desde Main
        System.out.println("Ingrese la edad de Juan (0-150):");
        int edad_juan = Integer.parseInt(sc.nextLine());
        int edad_alberto = calcular_edad_alberto(edad_juan);
        int edad_ana = calcular_edad_ana(edad_juan);
        int edad_mama = calcular_edad_mama(edad_juan, edad_alberto, edad_ana);
        System.out.println("LAS EDADES SON: ALBERTO="+edad_alberto+", JUAN="+edad_juan+", ANA="+edad_ana+", MAMA="+edad_mama);


    }
    private static int calcular_edad_alberto(int edad_juan){
        return (2 * edad_juan/3);
    }
    private static int calcular_edad_ana(int edad_juan){
        return (4 * edad_juan/3);
    }
    private static int calcular_edad_mama(int edad_juan, int edad_alberto, int edad_ana){
        return (edad_juan+edad_alberto+edad_ana);
    }


}
