import java.util.Scanner;

public class RemoveDupsInSortedLL {
    Node head=null;
    public static void removeDups(Node head){
        Node p=head;
        Node q;
        while(p!=null && p.next!=null){
            if(p.data ==p.next.data){
                q=p.next.next;
                if(q==null){
                    p.next=null;
                    break;
                }
                p.next=q;
            }
            if(p.data !=p.next.data){
                p=p.next;
            }
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
        removeDups(firstlist);
        printList(firstlist);

    }
}
