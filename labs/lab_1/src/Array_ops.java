import java.util.Random;

public class Array_ops {
    public static int[] random_array(int length){
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(1,21);
        }
        return array;

    }
    public static void print_array(int[] array){
        String printed_array = "";
        for(int i = 0; i < array.length; i++) {
            printed_array += array[i] + " ";
        }
        System.out.println(printed_array);
    }

    public static int dot_product(int[] array1 , int[] array2){
        int dot_product = 0;
        for (int i = 0 ; i < array1.length; i++){
            dot_product += array1[i] * array2[i];
        }
        return dot_product;
    }

    public static int sum_even_array(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static int average_array(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static int[] array_concat_order(int[] array1, int[] array2){
        int[] array_concat = new int[array1.length + array2.length];
        int j = 0;
        for(int i = 0; i< array1.length + array2.length; i+=2){
            array_concat[i] = array1[j];
            array_concat[i+1] = array2[j];
            j++;
        }
        return array_concat;

    }
    public static int max_array (int[] array ){
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max ){
                max = array[i];
            }
        }
        return max;
    }
}
