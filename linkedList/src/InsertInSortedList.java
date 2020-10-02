
import java.util.*;
import java.io.*;

public class InsertInSortedList {
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
    public static void sortedInsert(int data){
        Node currNode=head;//,prevNode=head;
        Node newNode=new Node(data);
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        }
        else{
            while(currNode.next!=null && currNode.next.data<newNode.data){
                currNode=currNode.next;
            }
            newNode.next=currNode.next;
            currNode.next=newNode;
        }
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
                sortedInsert(e);
            }
            int datainsert=sc.nextInt();
            sortedInsert(datainsert);

            head=null;
        }

    }
}