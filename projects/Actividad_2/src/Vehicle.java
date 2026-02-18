public class Vehicle {

    private String brand;
    private int model;
    private int engine;
    public enum fuels {
        PETROL, BIOETHANOL, DIESEL, BIODIESEL, NATURAL_GAS
    }
    private fuels fuelType;
    public enum vehType {
        CITY,SUBCOMPACT,COMPACT,FAMILY,EXECUTIVE, SUV
    }
    private vehType vehicleType;
    private int doors;
    private int seats;
    private int maxSpeed;
    public enum colorType {
        WHITE, BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET
    }
    private colorType color;
    private int currentSpeed = 0;
    private boolean isAutomatic;
    private int ticketAmount = 0;

    public Vehicle(String brand, int model, int engine, fuels fuelType, vehType vehicleType, int doors, int seats, int maxSpeed, colorType color,boolean isAutomatic) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.doors = doors;
        this.seats = seats;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.isAutomatic = isAutomatic;



    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public fuels getFuelType() {
        return fuelType;
    }

    public void setFuelType(fuels fuelType) {
        this.fuelType = fuelType;
    }

    public vehType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(vehType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public colorType getColor() {
        return color;
    }

    public void setColor(colorType color) {
        this.color = color;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public boolean getAutomatic(){
        return isAutomatic;
    }
    public void setAutomatic(boolean automatic){
        isAutomatic = automatic;
    }
    public void accelerate(int increment){
        if(currentSpeed + increment <= maxSpeed) {
            currentSpeed += increment;
        }else {
            ticketAmount =+ 10;
            System.out.println( "The vehicle can't go faster than " + maxSpeed + " km/h");
        }
    }
    public void brake(int decrement){
        if(currentSpeed - decrement >= 0) {
            currentSpeed -= decrement;
        }else {
            System.out.println("The vehicle can't go slower than 0 km/h");
        }
    }
    public void stop(){
        currentSpeed = 0;
    }
    public double calculateArrivalTime(double distance){
        return distance / currentSpeed;
    }
    public boolean haveTicket(){
        return ticketAmount > 0;
    }
    public void totalTicket(){
        System.out.println("Total ticket amount: " + ticketAmount + " USD");
    }


    public void print(){
        System.out.println("----- Vehicle Details -----");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Engine: " + engine);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Doors: " + doors);
        System.out.println("Seats: " + seats);
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Color: " + color);
        System.out.println("Current Speed: " + currentSpeed);
        System.out.println("Is Automatic: " + isAutomatic);
        System.out.println("Ticket Amount: " + ticketAmount + "USD");
    }


}
