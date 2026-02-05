import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    menu();

    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        byte option = 0;
        // Menú recursivo
        while (true) {
            System.out.println("Bienvenido a la colección de ejercicios de la Actividad 1.");
            System.out.println("Selecciona una opción (1-6):");
            System.out.println("1) Ejercicio Resuelto No 4");
            System.out.println("2) Ejercicio Resuelto No 5");
            System.out.println("3) Ejercicio Propuesto No 12");
            System.out.println("4) Ejercicio Propuesto No 14");
            System.out.println("5) Ejercicio Propuesto No 17");
            System.out.println("6) Salir");
            System.out.print("Opción: ");
            // obtiene input y borra espacios
            String in = sc.nextLine().trim();
            // verifica que sea Byte y lo transforma de string a byte, en caso que no hace catch a la exeption y carga nuevamente el menú
            try {
                option = Byte.parseByte(in);
            } catch (NumberFormatException e) {
                System.out.println("Opción no valida, intentalo de nuevo.\n");
                continue;
            }
            // verifica que sea opción valida
            if (option < 1 || option > 6) {
                System.out.println("Opción no valida, intentalo de nuevo..\n");
                continue;
            }
            try{
                // selector
                switch (option) {
                    case 1:
                        Resuelto_4.run();
                        break;
                    case 2:
                        Resuelto_5.run();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        sc.close();
                        System.exit(0);
                        break;
                }
            }catch(Exception e){
                System.out.println("Ocurrió un problema al correr la opción, intentalo de nuevo\n");
            }

        }
    }
}


