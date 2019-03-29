public class Radix{
    private MyLinkedList[] buckets = new MyLinkedList[10];
    private MyLinkedList result = new MyLinkedList();

    //don't use built-in linked list since merging them would be linear not constant time
    public void radixsort(int[] data){
        for (int bucket = 0; bucket < 10; bucket++){
            buckets[bucket] = new MyLinkedList();
        }
        int k = 1;
        //k is changed depending if there are any variables with more digits than previously thought
        for (int i = 0; i < k; i++){
            for (int n = 0; n < data.length; n++){
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
                result.extend(buckets[bucket]);
            }
            for (int n = 0; n < data.length; n++){
                data[n] = result.removeFront();
            }
        }
    }

    //gets the number at the digit of the number
    private int getDigit(int num, int digit){
        return num / (int)Math.pow(10, digit-1) % 10;
    }

    public void print(){
        for (int i = 0; i < buckets.length; i++){
            System.out.println(i+": "+buckets[i]);
        }
        System.out.println("result: "+result);
    }
}
