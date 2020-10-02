public class Main {
    public static void main(String[] args) {
        SingleLinkedList list=new SingleLinkedList();
        list.insertAtBeg(9);
        list.insertAtBeg(90);
        list.insertAtEnd(10);
        list.printList();
        list.insert(90,45);//num(for searching),data to be inserted
        list.printList();
        list.delete(9);
        list.printList();
    }
}
/*class Node
{
    int data;
    Node next;
};
static void reverse(Node head_ref)
        {
        Node prev   = NULL;
        Node current = head_ref;
        Node next;
        while (current != NULL)
        {
        next  = current.next;
        current.next = prev;
        prev = current;
        current = next;
        }
        //ADD A STATEMENT HERE
        }*/