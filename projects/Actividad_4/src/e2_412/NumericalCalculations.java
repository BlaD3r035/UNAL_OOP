package e2_412;

public class NumericalCalculations {
    // Nota profesor: al estar usando interfaz; el manejo de las ex se realiza
    // en el actionPerformed del botón, ya que se desea retornar el double del resultado y
    // no simplemente imprimirlo como en el ejemplo
    static double calculateNapierianLogarithm(double value){
        if(value < 0){
            throw new ArithmeticException("Value must be a positive number ");
        }
        return Math.log(value);
    }

    static double calculateSquareRoot(double value){
        if(value < 0){
            throw new ArithmeticException("Value must be a positive number ");
        }
        return Math.sqrt(value);
    }
}
