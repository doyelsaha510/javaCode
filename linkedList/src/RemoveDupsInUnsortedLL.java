import java.util.HashSet;
import java.util.Scanner;

public class RemoveDupsInUnsortedLL {
    /*1.Using Two Loops
    * 2.sort the linkedlist then remove
    * 3.use hashing tradeof between time and space */

    Node head=null;
    public static void removeDupsWithHashing(Node head){
        HashSet<Integer> hashSet=new HashSet<>();
        Node current=head;
        Node prev=null;
        while(current!=null){
            int value=current.data;
            if(hashSet.contains(value)){
                prev.next=current.next;
            }else{
                hashSet.add(value);
                prev=current;
            }
            current=current.next;
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

    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        Node firstlist=null;

        int list1count=sc.nextInt();
        for(int i=0;i<list1count;i++){
            int e=sc.nextInt();
            firstlist=new Node(e,firstlist);
        }
        printList(firstlist);
        removeDupsWithHashing(firstlist);
        printList(firstlist);

    }
}
