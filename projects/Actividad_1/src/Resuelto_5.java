public class Resuelto_5 {
    public static void run(){
       float suma = 0;
       float  x = 20;
       suma = first_operation(suma,x);
       float y = 40;
       x = second_operation(x,y);
       suma = third_operation(suma,x,y);
        System.out.println("El valor de la operation es: "+suma);
    }
    private static float first_operation(float suma, float x){
        return  (suma+x);
    }
    private static float second_operation(float x, float y) {
        double r = x + Math.pow(y, 2);
        return (float) Math.round(r);
    }
    private static float third_operation(float suma, float x, float y) {
        return (suma + x/y);
    }
}
/**
 * El codigo se puede escribir de la siguiente manera, pero con el fin de usar OOP se dejó las operaciones en metodo:
 * float suma = 0;
 * float x = 20;
 * suma = suma +x;
 * float y = 40;
 * x = x +Math.pow(y, 2);
 * suma = suma + x/y;
 * System.out.println("El valor de la operacion es: "+suma);
 */