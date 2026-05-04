package Shapes;

public class Sphere extends Shape{
    private double radius;

    public Sphere(double radius){
        this.radius = radius;
        this.setSurface(calculateSurface());
        this.setVolume(calculateSurface());

    }
    public double calculateVolume(){
        return 1.333 * Math.PI * Math.pow(this.radius,3.0);
    }

    public Double calculateSurface(){
        return 4.0 * Math.PI * Math.pow(radius, 2.0 );
    }
}
