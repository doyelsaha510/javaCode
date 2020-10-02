import java.util.Scanner;

public class ReverseLL {
    static Node head=null;
    static Node reverseWithRecursion(Node head)
    {
        if (head == null || head.next == null)
            return head;
        printList(head);
        System.out.println("*******************");
        /* reverse the rest list and put
        the first element at the end */
        Node rest = reverseWithRecursion(head.next);
        System.out.println("-------------------");
        printList(rest);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        printList(head);
        System.out.println("++++++++++++++++++");

        /* fix the head pointer */

        return rest;
    }
    public static Node reverserWithTailRecursion(Node curr,Node prev){
        if(curr.next==null){
            head=curr;
            curr.next=prev;
            return head;
        }
        Node next1=curr.next;
        curr.next=prev;
        reverserWithTailRecursion(next1,curr);
        return head;
    }
    public static Node reverserWithIterative(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return head;
    }
    public static void insert(int data)
    {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node tempNode=head;
            while(tempNode.next !=null){
                tempNode=tempNode.next;
            }
            tempNode.next=newNode;
        }
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

    private  static final Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int e=sc.nextInt();
            insert(e);
        }
        printList(head);
        //Node rev=reverseWithRecursion(head);
        //Node rev=reverserWithTailRecursion(head,null);
        Node rev=reverserWithIterative(head);
        printList(rev);
    }


}
