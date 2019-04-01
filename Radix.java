public class Radix{
    private static MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    private static MyLinkedList<Integer> result = new MyLinkedList();

    //Radix sort should get faster when the arraySize : maxValue ratio increases.
    //(More elements and smaller max value)
    public static void radixsort(int[] data){
        for (int bucket = 0; bucket < 10; bucket++){
            buckets[bucket] = new MyLinkedList();
        }
        int k = 1;
        //k is changed depending if there are any variables with more digits than previously thought
        for (int i = 0; i < k; i++){
            for (int n = 0; n < data.length; n++){
              //could be optimized to remove if statement at the end
                if (data[n] >= Math.pow(10,k)){
                    k++;
                }
                for (int bucket = 0; bucket < 10; bucket++){
                    if (getDigit(data[n], i+1) == bucket){
                        buckets[bucket].add(data[n]);
                    }
                }
            }
            for (int bucket = 0; bucket < 10; bucket++){
              System.out.println("got in loop");
                result.extend(buckets[bucket]);
                System.out.println(buckets[bucket]);
                System.out.println("result"+result);
            }
            System.out.println(result);
            for (int n = 0; n < data.length; n++){
                data[n] = result.removeFront();
            }
        }
        result.clear();
    }

    //gets the number at the digit of the number
    private static int getDigit(int num, int digit){
        return num / (int)Math.pow(10, digit-1) % 10;
    }

    public static void print(){
        for (int i = 0; i < buckets.length; i++){
            System.out.println(i+": "+buckets[i]);
        }
        System.out.println("result: "+result);
    }
}
