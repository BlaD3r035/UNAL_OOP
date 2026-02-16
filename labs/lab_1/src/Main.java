import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length for the arrays:");
        int array_length = sc.nextInt();
        while (array_length < 0 || array_length > 12){
            System.out.println("Invalid length, try again:");
            array_length = sc.nextInt();
        }
        int[] array1 = new int[array_length];
        int[] array2 = Array_ops.random_array(array_length);
        System.out.println("Enter the elements for the first array:");
        for (int i = 0; i < array_length; i++) {
            array1[i] = sc.nextInt();
        }
        int[] sum_array = new int[array_length];
        for (int i = 0; i < array_length; i++) {
            sum_array[i] = array1[i] + array2[i];
        }
        Array_ops.print_array(sum_array);
        System.out.println("Dot product: " + Array_ops.dot_product(array1, array2));
        System.out.println("Sum of even numbers in Array 1 : " + Array_ops.sum_even_array(array1));
        System.out.println("Average of Array 2: " + Array_ops.average_array(array2));
        int[] array3 = Array_ops.array_concat_order(array1, array2);
        Array_ops.print_array(array3);
        System.out.println("Max number in Array 3: " + Array_ops.max_array(array3));



    }





}