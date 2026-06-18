package e4_406;

public class Seller {
    String firstName;
    String lastName;
    int age;

     Seller(String firstName, String lastName){
         this.firstName = firstName;
         this.lastName = lastName;

    }

    void print(){
        System.out.println("Seller's First Name: " + this.firstName);
        System.out.println("Seller's Last Name: " + this.lastName);
        System.out.println("Seller's Age: " + this.age);
    }

    String sellerString() {
        return String.format("""
                Seller's information:
                First Name: %s
                Last Name: %s
                Age: %d
                """, this.firstName, this.lastName, this.age);
    }

    void checkAge(int age){
         // Nota profesor: Dejo el check del rango de edad primero ya que no tiene sentido
         // comparar primero si es mayor de adad sin antes verificar que la edad no sea negativa (Mensaje de Ex incorrecto)
        if(age >= 0 && age < 120 ){
            this.age = age;
        }else throw new IllegalArgumentException("Seller's age must be in range 0 to 120");

        if(age < 18){
             throw new IllegalArgumentException("Seller's age must be 18+");
        }

    }

}
