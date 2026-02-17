import java.util.Scanner;
public class Ej2_1_pg63 {
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person[] people = new Person[2];
        for (int i = 0; i < people.length; i++) {
            System.out.println("Create the person " + (i + 1) + ":");
            System.out.println("Enter the first name:");
            String firstName = sc.nextLine();
            System.out.println("Enter the last name:");
            String lastName = sc.nextLine();
            System.out.println("Enter the ID:");
            String id = sc.nextLine();
            System.out.println("Enter the year of birth:");
            int yearOfBirth = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the place of birth:");
            String placeOfBirth = sc.nextLine();
            System.out.println("Enter the gender (M/F):");
            char gender = sc.next().charAt(0);
            sc.nextLine();
            people[i] = new Person(firstName, lastName, id, yearOfBirth, placeOfBirth, gender);

        }

        for (Person person : people) {
            person.print();
        }
    }
}
