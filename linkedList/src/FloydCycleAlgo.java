import java.util.Scanner;

public class FloydCycleAlgo {
    private static boolean loop=false;
    private static Node slow,fast;
    private static boolean findCycle(Node head){
        slow=head;
        fast=head;
        while(slow!=null && fast !=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;

            System.out.println(slow.data+" "+fast.data);
            if(slow==fast) {
                loop = true;
                System.out.println("fast.next.data"+fast.next.data);
                return true;
            }
        }

        System.out.println("*************");
        return false;
    }
    private static Node startNode(Node fast,Node head){

            Node slow1=head;
        System.out.println(slow1.data+" "+fast.data);
            while (fast !=slow1){
                System.out.println("Before "+slow1.data+" "+fast.data);
                fast= fast.next;
                slow1=slow1.next;
                System.out.println("After "+slow1.data+" "+fast.data);
            }

        System.out.println("*************");
            //slow=slow1;
        return fast;

    }
    private static int lengthofListCycle(Node fast2,Node head){
        int length = 0;
        slow = head;
        int i=0;
        while (fast2 != slow) {
            fast2 = fast2.next;
            slow = slow.next;
            //System.out.println(fast2.data+" "+slow.data);
        }

        do {
            fast2 = fast2.next;
            length++;
        } while (fast2 != slow);


        return length;
    }
    private static Node removeLoop(Node fast2,Node head){
        slow = head;

        while (fast2 != slow) {
            fast2 = fast2.next;
            slow = slow.next;
        }

        while (fast2.next != slow) {
            fast2 = fast2.next;
        }

        fast2.next = null;


        return head;

    }
    private  static final Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        SingleLinkedList myLinkedList=new SingleLinkedList();
        /*myLinkedList.head = new Node(1);
        myLinkedList.head.next = new Node(2);
        Node node = myLinkedList.head.next.next = new Node(3);
        myLinkedList.head.next.next.next = new Node(4);
        myLinkedList.head.next.next.next.next = new Node(5);
        myLinkedList.head.next.next.next.next.next = node;*/
        int listCount=sc.nextInt();
        for (int i = 0; i < listCount; i++) {
            int listItem=sc.nextInt();
            myLinkedList.insertAtEnd(listItem);
        }

        System.out.println(myLinkedList.head.next.next.next.next.next.next.next.data);
        System.out.println(myLinkedList.head.next.next.next.data);
        myLinkedList.head.next.next.next.next.next.next.next=myLinkedList.head.next.next.next;//to make cycle
        //list.printList();
        boolean foundCycle=findCycle(myLinkedList.head);
        if (foundCycle){
            System.out.println("Cycle found");
            Node startNodeItem=startNode(fast,myLinkedList.head);
            System.out.println("StartNode : "+startNodeItem.data);
            int lengthofCycle=lengthofListCycle(fast,myLinkedList.head);
            System.out.println("length of cycle : "+lengthofCycle);
            Node remove=removeLoop(fast,myLinkedList.head);
            System.out.println("Removing Loop : "+remove.data);
            boolean foundCycleAfterRemove=findCycle(myLinkedList.head);
            if(foundCycleAfterRemove){
                System.out.println("Again Cycle found");
            }
            else{
                System.out.println("Cycle Removed");
            }
        }
        else
            System.out.println("Cycle NOT found");
    }
}
