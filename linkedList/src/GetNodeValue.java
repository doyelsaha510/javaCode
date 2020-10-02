import java.util.Scanner;

public class GetNodeValue {
    static int getNode(Node head, int positionFromTail) {

        Node node=head;
        int counter=0;
        while(head!=null){
            head=head.next;
            if(counter< positionFromTail){
                counter++;
            }else if(head!=null){
                node=node.next;
            }
        }
        return node.data;

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
        int nodeValue=getNode(firstlist,2);
        System.out.println(nodeValue);

    }
}
