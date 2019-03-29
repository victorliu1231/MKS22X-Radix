public class MyLinkedList<E>{
    private int length;
    private Node start, end;

    public MyLinkedList(){ //make comments, special cases, fix second add method
      length = 0;
    }

    public void clear(){
        length = 0;
    }

    public void add(E value){
        Node newNode = new Node(value);
        if (length != 0){
          newNode.setPrev(end);
          end.setNext(newNode);
          end = newNode;
        } else { //if the length is 0, that means this is the first Node, so start and end link both to the first
          start = newNode;
          end = newNode;
        }
        length++;
    }

    public void extend(MyLinkedList<E> other){ //O(1) runtime
        //first step is to link the loose ends of the LinkedLists
        if (other.length == 0){
            return;
        }
        if (this.length == 0){
            start = other.start;
        } else {
            this.end.setNext(other.start);
            //second step is to update the first LinkedList's end and length
            this.length += other.length;
            this.end = other.end;
        }
    }

    public int size(){
        return length;
    }

    public E removeFront(){
        //if the index is out of bounds, necessary to throw the correct exception
        if (length == 0){
            throw new IndexOutOfBoundsException();
        }
        E ans = start.data();
        if (length > 1){
            //if you are removing from the start, you don't have to update the previous Node since it doesn't exist
            start.next().setPrev(null);
            start = start.next();
        } else { //a special case happens when the list is 1 element long... you can't call ans.next() or ans.prev()
            start = null;
            end = null;
        }
        length--;
        return ans;
    }

    public String toString(){
        Node current = start;
        String str = "[";
        //using the while loop and "current" method of indexing instead of getNode(), you avoid O(n^2) and just have O(n)
        for (int n = 0; n < length; n++){ //if current IS null, that's the end, and this whole loop terminates
          str+= current.data();
          //below if statement just makes sure you aren't adding commas at the end of the list, and only in the middle
          if (current.next() != null){
              str+= ", ";
          }
          //the equivalent of indexing
          current = current.next();
        }
        str += "]";
        return str;
    }

    public String toStringDebug(){
        Node current = start;
        String str = "[";
        //using the while loop and "current" method of indexing instead of getNode(), you avoid O(n^2) and just have O(n)
        for (int n = 0; n < length; n++){ //if current IS null, that's the end, and this whole loop terminates
            if (current != start){
                str+= "(prev: "+current.prev().data()+") ";
            } else {
                str+= "(prev: null) ";
            }
            str+= current.data();
            if (current != end){
                str+= " (next: "+current.next().data()+")";
            } else {
                str+= " (next: null)";
            }
            //below if statement just makes sure you aren't adding commas at the end of the list, and only in the middle
            if (current.next() != null){
                str+= ", ";
            }
            //the equivalent of indexing
            current = current.next();
        }
        str += "]";
        return str;
    }

    public class Node{
        private E data;
        private Node next,prev;
        
        //I think this whole class is pretty self explanatory
        public Node(E data){
            this.data = data;
        }
    
        public void setNext(Node other){
            next = other;
        }
        public Node next(){
            return next;
        }
        public void setPrev(Node other){
            prev = other; //throw same exceptions as superarray for add/remvoe stuff
        }
        public Node prev(){
            return prev;
        }
        public void setData(E value){
            data = value;
        }
        public E data(){
            return data;
        }
        public String toString(){
            return ""+data;
        }
    }
}
