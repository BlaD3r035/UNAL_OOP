public class RightTriangle {
    private int base;
    private int height;

    public RightTriangle(int base, int height){
        this.base = base;
        this.height = height;
    }
    public double calculateArea(){
        return ((double) (base * height/2) );
    }

    public double calculatePerimeter(){
        return base + height + calculateHypotenuse();
    }

    public double calculateHypotenuse(){
        return Math.pow(base*base + height*height, 0.5);
    }

    public void typeOfTriangle(){
        if ((base == height) && (base == calculateHypotenuse()) && (height
                == calculateHypotenuse()))
            System.out.println("This is an Equilateral triangle");
        else if ((base != height) && (base != calculateHypotenuse()) &&
                (height != calculateHypotenuse()))
            System.out.println("This is a Scalene triangle");
        else
            System.out.println("This is an Isosceles triangle");

    }
}
