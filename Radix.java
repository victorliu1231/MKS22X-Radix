import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Radix{
    private static MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    private static MyLinkedList<Integer> result = new MyLinkedList();

    //Radix sort should get faster when the arraySize : maxValue ratio increases.
    //(More elements and smaller max value)
    public static void radixsort(int[] data){
        for (int bucket = 0; bucket < 19; bucket++){
            buckets[bucket] = new MyLinkedList();
        }
        boolean didNotFindBiggerDigit = true;
        int i = 1;
        //k is changed depending if there are any variables with more digits than previously thought
        while (didNotFindBiggerDigit){
            for (int n = 0; n < data.length; n++){
                int current = data[n];
                int digit = getDigit(current, i);
                buckets[9 + digit].add(current);
            }
            for (int bucket = 0; bucket < 19; bucket++){
                MyLinkedList currentBucket = buckets[bucket];
                didNotFindBiggerDigit = bucket != 9 && currentBucket.size() > 0;
                result.extend(currentBucket);
                currentBucket.clear();
            }
            for (int n = 0; n < data.length; n++){
                data[n] = result.forward();
            }
            result.clear();
            i++;
        }
    }

    //gets the number at the digit of the number
    public static int getDigit(int num, int digit){
        return num / (int)Math.pow(10, digit-1) % 10;
    }

    public static void print(){
        for (int i = 0; i < buckets.length; i++){
            System.out.println(i+": "+buckets[i]);
        }
        System.out.println("result: "+result);
    }
}
