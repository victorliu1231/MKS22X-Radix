import java.util.LinkedList;

public class Driver{
    public static void main(String[] args){

        //test and removeFront
        
        MyLinkedList<Integer> l1 = new MyLinkedList<>();
        LinkedList a1 = new LinkedList();
        a1.add(1);
        l1.add(1);
        l1.add(2);
        a1.add(2);
        System.out.println(l1.size()); //2
        System.out.println(a1.size()); //2
        System.out.println(l1); //[1, 2]
        System.out.println(a1); //[1, 2]
        a1.clear();
        l1.clear();
        System.out.println(l1); //[]
        System.out.println(a1); //[]

        MyLinkedList l3 = new MyLinkedList();
        MyLinkedList l4 = new MyLinkedList();
        for (int n = 0; n < 10; n++){
            l3.add(n);
        }
        for (int n = 10; n < 20; n++){
            l4.add(n);
        }
        System.out.println(l3);
        l3.extend(l4);
        System.out.println(l3);
        System.out.println(l3.size()); //20
        for (int i = 0; i < 10; i++){
            l3.removeFront();
        }
        System.out.println(l3); //from 10 to 20
        System.out.println(l3.size()); //10
    }
}
