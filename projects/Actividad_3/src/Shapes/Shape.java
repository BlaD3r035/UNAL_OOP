package Shapes;

public class Shape {
    private double volume;
    private double surface;


    public double setVolume(double volume){
        this.volume = volume;
        return  volume;
    }
    public double setSurface(double surface ){
        this.surface = surface;
        return  surface;
    }
    public double getVolume(){
        return  this.volume;
    }
    public double getSurface(){
        return this.surface;
    }

}
