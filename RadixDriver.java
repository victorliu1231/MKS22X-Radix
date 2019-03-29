import java.util.Arrays;
import java.util.Random;

public class RadixDriver{
    public static void main(String[]args){
        //WAIT WHAT ABOUT NEGATIVES
        //TEST RUNTIME
        generate(10000, 10);
    }

    public static void generate(int maxVal, int numEles){
        Random r = new Random();
        int[] data = new Integer[numEles];
        for (int i = 0; i < data.length; i++){
            data[i] = r.nextInt(maxVal);
        }
        Radix radix = new Radix<>();
        Radix.radixsort(data);
        System.out.println(Arrays.toString(data));
    }
}