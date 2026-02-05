public class Resuelto_5 {
    public static void run(){
       float suma = 0;
       float  x = 20;
       suma = primera_operacion(suma,x);
       float y = 40;
       x = segunda_operacion(x,y);
       suma = tercera_operacion(suma,x,y);
        System.out.println("El valor de la operacion es: "+suma);
    }
    private static float primera_operacion(float suma, float x){
        return  (suma+x);
    }
    private static float segunda_operacion(float x, float y) {
        double r = x + Math.pow(y, 2);
        return (float) Math.round(r);
    }
    private static float tercera_operacion(float suma, float x, float y) {
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