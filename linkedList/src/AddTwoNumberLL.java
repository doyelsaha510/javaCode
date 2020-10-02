import java.util.Scanner;

public class AddTwoNumberLL {
    Node head=null;
    public static Node addTwoNumbers(Node first,Node second){
        Node addedList=new Node(0);
        Node curr=addedList;
        int carry=0,sum;
        while (first!=null || second!=null){
            sum=carry+ (first!=null ? first.data : 0) +(second!=null ? second.data : 0);
            carry=sum/10;
            curr.next=new Node(sum%10);
            curr=curr.next;
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }

        }
        if(carry>0){
            curr.next=new Node(carry);
        }
        return addedList.next;
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
        Node firstlist=null,secondlist=null;

        int list1count=sc.nextInt();
        for(int i=0;i<list1count;i++) {
            int e = sc.nextInt();
            firstlist = new Node(e, firstlist);
        }
        printList(firstlist);
        int list2count=sc.nextInt();
        for(int i=0;i<list2count;i++){
            int e=sc.nextInt();
            secondlist=new Node(e,secondlist);
        }
        printList(secondlist);
        Node add=addTwoNumbers(firstlist,secondlist);
        printList(add);

    }
}
