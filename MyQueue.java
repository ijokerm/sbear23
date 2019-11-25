package ShujuJiegou;

public class MyQueue {
    //用链表实现一个队列
       static  class Node{
        Node next=null;
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    private Node front=null;
    private Node rear=null;
    int size=0;

    public void add(int element){
        size++;
        if(rear!=null){
            rear.next=new Node(element);
            rear=rear.next;
        }
        front=rear=new Node(element);
    }
    public int poll(){
        int element=front.val;
        size--;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return element;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int front(){
        return front.val;
    }
    public int rear(){
        return rear.val;
    }
    public void display(){
        for(Node cur=front;cur!=null;cur=cur.next){
            System.out.println(cur.val);
        }
    }
}
