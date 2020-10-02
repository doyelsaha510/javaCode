class Node{
    int data;
    Node prev;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
/*Advantages:
    1.move in both direction
    2.easy to access element
Disadvantages:
    1. extra pointer(space)
    2.every time manipulating the extra pointer
*/

public class DoubleLinkedList {
    Node head=null;
    public void insertAtBeg(int data){ //Time complexity O(1)
        Node newNode=new Node(data);
        if(head==null)
        {
            //means list is empty
            head=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void insertAtEnd(int data){ //Time Complexity O(n)
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node tempNode=head;
        while(tempNode.next!=null){
            tempNode=tempNode.next;
        }
        tempNode.next=newNode;
        newNode.prev=tempNode;

    }
    public void insert(int num,int data){
        /*1.next of newNode should be node2
        * 2.next of node1 should be newNode
        * 3.prev of node2 newNode
        * 4.prev of newNode is node1*/

        Node tempNode=head;
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }

        while(tempNode!=null && tempNode.data!=num){
            tempNode=tempNode.next;
        }

        newNode.next=tempNode.next;
        tempNode.next=newNode;
        if (newNode.next!=null) {
            newNode.next.prev = newNode;
        }
        newNode.prev=tempNode;
    }
    public void delete(int data){ //time complexity O(n)

        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node delNode=head;
        while (delNode!=null &&delNode.data!=data) {
            delNode=delNode.next;
        }
        if(delNode==head){
            head=head.next;
            head.prev=null;
            return;
        }

        delNode.prev.next=delNode.next;
        if(delNode.next!=null) {
            delNode.next.prev = delNode.prev;
        }
    }
    public void printList(){
        Node tempNode=head;
        while(tempNode !=null) {
            System.out.println(tempNode.data);
            tempNode=tempNode.next;
        }
        System.out.println("----------------------------------------------");
    }

}
