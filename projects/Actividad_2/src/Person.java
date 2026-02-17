public class Person {
    private String firstName;
    private String lastName;
    private String id;
    private int yearOfBirth;
    private String placeOfBirth;
    private char gender;

    public Person(String name, String lastName, String id, int yearOfBirth, String placeOfBirth, char gender) {
        this.firstName = name;
        this.lastName = lastName;
        this.id = id;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
    }

    public void print() {
        System.out.println("Name = " + firstName);
        System.out.println("Last Name = " + lastName);
        System.out.println("ID = " + id);
        System.out.println("Year of Birth = " + yearOfBirth);
        System.out.println("Place of Birth = " + placeOfBirth);
        System.out.println("Gender = " + gender);
        System.out.println();
    }

}
