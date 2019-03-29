public class Node {
    private Integer data;
    private Node next,prev;

    //I think this whole class is pretty self explanatory
    public Node(int data){
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
    public void setData(Integer value){
        data = value;
    }
    public int data(){
      return data;
    }
    public String toString(){
        return ""+data;
    }
}
