import java.util.Scanner;

public class Ej2_3_pg73 {
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vehicle brand: ");
        String brand = sc.nextLine();

        System.out.println("Enter vehicle model: ");
        int model = sc.nextInt();

        System.out.println("Enter engine size: ");
        int engine = sc.nextInt();
        sc.nextLine();

        System.out.println("Select fuel type (PETROL, BIOETHANOL, DIESEL, BIODIESEL, NATURAL_GAS): ");
        Vehicle.fuels fuelType = Vehicle.fuels.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Select vehicle type (CITY, SUBCOMPACT, COMPACT, FAMILY, EXECUTIVE, SUV): ");
        Vehicle.vehType vehicleType = Vehicle.vehType.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Enter number of doors: ");
        int doors = sc.nextInt();

        System.out.println("Enter number of seats: ");
        int seats = sc.nextInt();

        System.out.println("Enter max speed: ");
        int maxSpeed = sc.nextInt();
        sc.nextLine();

        System.out.println("Select color (WHITE, BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET): ");
        Vehicle.colorType color = Vehicle.colorType.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Is automatic? (true/false): ");
        boolean isAutomatic = sc.nextBoolean();

        Vehicle car1 = new Vehicle(brand, model, engine, fuelType, vehicleType, doors, seats, maxSpeed, color, isAutomatic);

        car1.print();

       System.out.println("Enter speed to set: ");
        int speedToSet = sc.nextInt();
        car1.setCurrentSpeed(speedToSet);
        System.out.println("Current speed = " + car1.getCurrentSpeed() + " km/h");

        System.out.println("Enter acceleration value: ");
        int accelerationValue = sc.nextInt();
        car1.accelerate(accelerationValue);
        System.out.println("Current speed = " + car1.getCurrentSpeed() + " km/h");

        System.out.println("Enter braking value: ");
        int brakingValue = sc.nextInt();
        car1.brake(brakingValue);

        if(car1.haveTicket()){
            System.out.println("You have a ticket!");
            car1.totalTicket();

        }


    }
}
