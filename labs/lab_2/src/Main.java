import java.util.Scanner;
public class Main {
    static public void main(String[] args){
        Date date = new Date(16, 7, 2007);
        System.out.println(date.toString());
        Address address = new Address("San Pasqual","St","South East Pasadena","Pasadena","9999","101");
        System.out.println(address.toString());
        User user = new User ("Samuel Alejandro", 123456789);
        user.setBirthDate(date);
        user.setBirthPlace("Pasadena");
        user.setPhoneNumber(123456789);
        user.setEmail("estepasamuelalejandro@gmail.com");
        user.setAddress(address);
        System.out.println(user.toString());

        // now the input program
        Scanner sc = new Scanner(System.in);
        System.out.println("User program: ");
        System.out.println("Enter the user's name: ");
        String name = sc.nextLine();
        System.out.println("Enter the user's id: ");
        long id = sc.nextLong();
        sc.nextLine(); // consume leftover newline after id
        User user1 = new User(name, id);
        System.out.println("Enter the user's birth day, month and year: ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        Date birthDate = new Date(day, month, year);
        user1.setBirthDate(birthDate);
        sc.nextLine();
        System.out.println("Enter the user's birth place: ");
        String birthPlace = sc.nextLine();
        user1.setBirthPlace(birthPlace);
        System.out.println("Enter the user's phone number: ");
        long phoneNumber = sc.nextLong();
        sc.nextLine(); // consume leftover newline after phone number
        user1.setPhoneNumber(phoneNumber);
        System.out.println("Enter the user's email: ");
        String email = sc.nextLine();
        user1.setEmail(email);
        System.out.println("Enter the user's address: ");
        System.out.println("Enter the user's street: ");
        String street = sc.nextLine();
        System.out.println("Enter the user's nomenclature: ");
        String nomenclature = sc.nextLine();
        System.out.println("Enter the user's neighbourhood: ");
        String neighbourhood = sc.nextLine();
        System.out.println("Enter the user's city: ");
        String city = sc.nextLine();
        System.out.println("Enter the user's building: ");
        String building = sc.nextLine();
        System.out.println("Enter the user's apartment: ");
        String apartment = sc.nextLine();
        Address address1 = new Address(street, nomenclature, neighbourhood, city, building, apartment);
        user1.setAddress(address1);
        System.out.println(user1.toString());






    }
}
