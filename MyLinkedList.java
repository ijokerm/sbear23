package ShujuJiegou;

class Node{
    Object data;
    Node next;

    public Node(Object data){
        this.data=data;
        this.next=null;
    }
}
public class MyLinkedList {
    public static Node createList(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        return n1;
    }
    public static Node addFirst(Node head,String data){
        Node newNode=new Node(data);
            newNode.next=head;
            head=newNode;
        return newNode;
    }
    public static void addRandom(Node index,String data){
        Node newNode=new Node(data);
        newNode.next=index.next;
        index.next=newNode;
    }
    public static Node addLast(Node head,String data){
       if(head==null){
           return addFirst(head,data);
       }else {
           Node newNode = new Node(data);
           Node cur = getLast(head);
           cur.next = newNode;
       }
       return head;
    }
    public static Node  getLast(Node head){
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        return cur;
    }
    public static Node popFirst(Node head) {
        if (head == null) {
         return null;
        }
        return head.next;
    }
    public static void popRandom(Node index){
        if(index==null){
            return;
        }
        Node oldNode=index.next;
        index.next=oldNode.next;
    }
    public static Node popLast(Node head){
       if(head==null){
           return null;
       }else if(head.next==null){
           return null;
       }
        Node last=get_Lsat(head);
        last.next=null;
        return head;
    }
    public static Node get_Lsat(Node head){
        Node cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        return cur;
    }


    public static void  display(Node head){
       for(Node cur=head;cur!=null;cur=cur.next){
          //System.out.printf("(%d)-->",cur.data);
          System.out.println(cur.data);
       }
          System.out.println("null");
      }


    public static void main(String[] args) {
     Node n=createList();
     n=addFirst(n,"x");
     Node index=n;
     addRandom(index,"t");

    // Node n=null;
     n=addLast(n,"a");
     n=popFirst(n);
     display(n);
     popLast(n);
     display(n);
    }
}
