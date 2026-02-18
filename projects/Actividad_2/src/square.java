public class square {
    private int side;

    public square(int side){
        this.side = side;
    }
    public double calculateArea(){
        return side*side;
    }
    public double calculatePerimeter(){
        return 4*side;
    }
}
