import java.util.Scanner;

public class MergeSortLL {
    Node head = null;
    public static Node sortedMergeList(Node firstL_h,Node secondL_h){
        Node sortedNode=null;
        if(firstL_h==null)
            return secondL_h;
        if(secondL_h==null)
            return firstL_h;
        if(firstL_h.data<=secondL_h.data){
            sortedNode=firstL_h;
            sortedNode.next=sortedMergeList(firstL_h.next,secondL_h);
        }else{
            sortedNode=secondL_h;
            sortedNode.next=sortedMergeList(firstL_h,secondL_h.next);
        }
        return sortedNode;
    }
    public static Node mergerSort(Node h){
        if(h==null ||h.next==null)
            return h;
        Node middleNode=getMiddleNode(h);
        System.out.println("Middle node"+middleNode.data);
        Node nextOfMiddleNode=middleNode.next;
        middleNode.next=null;
        Node first_half=mergerSort(h);
        System.out.println("First half");
        printList(first_half);
        Node second_half=mergerSort(nextOfMiddleNode);
        System.out.println("Second Half");
        printList(first_half);
        Node sortedList= sortedMergeList(first_half,second_half);
        return sortedList;
    }
    public static Node getMiddleNode(Node head){
        Node slow=head,fast=head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
        Node sortedList=mergerSort(firstlist);
        printList(sortedList);


    }
}
