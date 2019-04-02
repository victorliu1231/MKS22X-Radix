import java.util.Arrays;

public class Radix{
    private static MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    private static MyLinkedList<Integer> result = new MyLinkedList();

    //Radix sort should get faster when the arraySize : maxValue ratio increases.
    //(More elements and smaller max value)
    public static void radixsort(int[] data){
        for (int bucket = 0; bucket < 20; bucket++){
            buckets[bucket] = new MyLinkedList();
        }
        int k = 2;
        //k is changed depending if there are any variables with more digits than previously thought
        for (int i = 1; i < k; i++){
            for (int n = 0; n < data.length; n++){
                int digit = getDigit(data[n], i);
                int current = data[n];
                for (int bucket = 0; bucket < 10; bucket++){
                    //System.out.println("bucket: "+bucket+", data[n]: "+data[n]+", digit: "+digit+", current place: "+i);
                    if (current < 0 && bucket == digit){
                        buckets[9 - bucket].add(current);
                        //System.out.println(buckets[9 - bucket]);
                    } else if (digit == bucket){
                        buckets[10 + bucket].add(current);
                        //System.out.println(buckets[10 + bucket]);
                    }
                }
            }
            boolean didNotFindBiggerDigit = true;
            for (int bucket = 0; bucket < 20; bucket++){
                if (didNotFindBiggerDigit && bucket != 9 && bucket != 10 && buckets[bucket].size() > 0){
                    k++;
                    didNotFindBiggerDigit = false;
                }
                result.extend(buckets[bucket]);
                buckets[bucket].clear();
            }
            for (int n = 0; n < data.length; n++){
                data[n] = result.forward();
            }
            result.clear();
        }
    }

    //gets the number at the digit of the number
    public static int getDigit(int num, int digit){
        return Math.abs(num / (int)Math.pow(10, digit-1) % 10);
    }

    public static void print(){
        for (int i = 0; i < buckets.length; i++){
            System.out.println(i+": "+buckets[i]);
        }
        System.out.println("result: "+result);
    }
}
