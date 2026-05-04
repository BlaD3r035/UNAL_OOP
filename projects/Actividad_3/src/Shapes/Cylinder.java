package Shapes;

public class Cylinder extends Shape{
    private double radius;
    private double height;

    public Cylinder(double radius, double height){
        this.radius = radius;
        this.height = height;
        this.setSurface(this.calculateSurface());
        this.setVolume(this.calculateVolume());

    }

    public double calculateVolume(){
        return  Math.PI * height * Math.pow(radius,2.0);
    }
    public double calculateSurface(){
        double areaA = 2.0 * Math.PI * radius  * height;
        double areaB = 2.0 * Math.PI * Math.pow(radius,2.0);
        return  areaB + areaA;
    }

}
