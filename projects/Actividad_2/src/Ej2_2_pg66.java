import java.util.Scanner;

public class Ej2_2_pg66 {
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Planet[] planets = new Planet[2];
        for (int i = 0; i < planets.length; i++) {
            System.out.println("Create the planet " + (i + 1) + ":");
            System.out.println("Enter the name:");
            String name = sc.nextLine();
            System.out.println("Enter the number of satellites:");
            int satellites = sc.nextInt();
            System.out.println("Enter the mass:");
            double mass = sc.nextDouble();
            System.out.println("Enter the volume:");
            double volume = sc.nextDouble();
            System.out.println("Enter the diameter:");
            int diameter = sc.nextInt();
            System.out.println("Enter the distance to the sun:");
            int sunDistance = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the type (TERRESTRIAL/GAS_GIANT/DWARF):");
            Planet.PlanetType type = Planet.PlanetType.valueOf(sc.nextLine());
            System.out.println("Is it visible? (true/false):");
            boolean isVisible = sc.nextBoolean();
            sc.nextLine();
            System.out.println("Enter the orbital period:");
            int orbitalPeriod = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the rotation period:");
            int rotationPeriod = sc.nextInt();
            sc.nextLine();
            planets[i] = new Planet(name, satellites, mass, volume, diameter, sunDistance, type, isVisible,orbitalPeriod,rotationPeriod);
        }
        for (Planet planet : planets) {
            planet.print();
            System.out.println("Density = " + planet.density());
            System.out.println("Is Outer Planet? " + planet.isOuterPlanet());
            System.out.println();
        }
    }
}
