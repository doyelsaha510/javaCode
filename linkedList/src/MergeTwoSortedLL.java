import java.util.Scanner;

public class MergeTwoSortedLL {
    public static Node mergeTwoSortedLL(Node p,Node q){
        Node s=null;
        Node newHead=null;
        if(p==null)
            return q;
        if (q==null)
            return p;
        if(p!=null &&q!=null){
            if(p.data<=q.data){
                s=p;
                p=p.next;
            }
            else {
                s=q;
                q=q.next;
            }
        }
        newHead=s;
        while (p!=null &&q!=null){
            if(p.data<=q.data){
                s.next=p;
                s=p;
                p=s.next;
            }
            else{
                s.next=q;
                s=q;
                q=s.next;
            }
        }
        if(p==null)
            s.next=q;
        if(q==null)
            s.next=p;
        return newHead;
    }
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }
    public static Node reverse(Node head)
    {
        Node out = null;
        Node current = head;

        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            Node next = current.next;

            // move the current node onto the out
            current.next = out;
            out = current;

            // process next node
            current = next;
        }

        // fix head
        return out;
    }

    private  static final Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
            Node firstlist=null,secondlist=null;

            int list1count=sc.nextInt();
            for(int i=0;i<list1count;i++){
                int e=sc.nextInt();
                firstlist=new Node(e,firstlist);
            }
            firstlist=reverse(firstlist);
            printList(firstlist);
            int list2count=sc.nextInt();
            for(int i=0;i<list2count;i++){
                int e=sc.nextInt();
                secondlist=new Node(e,secondlist);
            }
            secondlist=reverse(secondlist);
            printList(secondlist);
            Node sortedlist= mergeTwoSortedLL(firstlist,secondlist);
            printList(sortedlist);

    }
}
