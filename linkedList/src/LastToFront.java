import java.io.IOException;
import java.util.Scanner;
/*i/p head->1->2->3->4->5->NULL
* o/p head->5->1->2->3->4->NULL
* Move last element to first*/
public class LastToFront { //Time Complexity O(n)
    public static Node head=null;
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
    public static void lastToFront(Node head){
        if(head == null)
            return;
        if(head.next == null){
            System.out.println(head.data);
            return;
        }

        Node temp=head;
        Node secondLast=null;
        while(temp.next!=null){
            secondLast=temp;
            temp=temp.next;
        }
        secondLast.next=null;
        temp.next=head;
        head=temp;

        Node tempNode=head;
        while(tempNode !=null) {
            System.out.print(tempNode.data+" ");
            tempNode=tempNode.next;
        }
        System.out.println();
    }

    private  static final Scanner sc=new Scanner(System.in);
    public static void main(String args[]) throws IOException {

        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                int e=sc.nextInt();
                insert(e);
            }
            lastToFront(head);
            head=null;
        }

    }
}