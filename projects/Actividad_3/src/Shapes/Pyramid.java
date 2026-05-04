package Shapes;

public class Pyramid extends Shape{
    private double base;
    private double height;
    private double slantHeight;

    public Pyramid(double base, double height, double slantHeight){
        this.base = base;
        this.height = height;
        this.slantHeight = slantHeight;
        this.setSurface(calculateSurface());
        this.setVolume(calculateVolume());
    }

    public double calculateVolume(){
        return  (Math.pow(base,2.0) * height) /3.0;
    }
    public double calculateSurface(){
        double areaBase = Math.pow(base, 2.0);
        double areaSide = 2.0 * base * slantHeight;
        return  areaBase + areaSide;
    }

}
