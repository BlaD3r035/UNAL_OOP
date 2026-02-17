public class Planet {
    private String name;
    private int satellites = 0;
    private double mass = 0;
    private double volume = 0;
    private int diameter = 0;
    private int sunDistance = 0;
    public enum PlanetType {
        TERRESTRIAL, GAS_GIANT, DWARF
    }
    private PlanetType type;
    private boolean isVisible = false;
    private int orbitalPeriod = 0;
    private int rotationPeriod = 0;

    public Planet(String name, int satellites, double mass, double volume, int diameter,int sunDistance, PlanetType type, boolean isVisible, int orbitalPeriod, int rotationPeriod) {
        this.name = name;
        this.satellites = satellites;
        this.mass = mass;
        this.volume = volume;
        this.diameter = diameter;
        this.sunDistance = sunDistance;
        this.type = type;
        this.isVisible = isVisible;
        this.orbitalPeriod = orbitalPeriod;
        this.rotationPeriod = rotationPeriod;
    }
    public void print() {
        System.out.println("Name = " + name);
        System.out.println("Satellites = " + satellites);
        System.out.println("Mass = " + mass);
        System.out.println("Volume = " + volume);
        System.out.println("Diameter = " + diameter);
        System.out.println("Sun Distance = " + sunDistance);
        System.out.println("Type = " + type);
        System.out.println("Visible = " + isVisible);
        System.out.println("Orbital Period = " + orbitalPeriod);
        System.out.println("Rotation Period = " + rotationPeriod);
    }

    public double density() {
        return mass / volume;
    }
    public boolean isOuterPlanet(){
        float limit = (float)(149597870 * 3.4);
        return (sunDistance > limit);
    }


}
