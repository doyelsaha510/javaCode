class Node{
    int data;
    Node next;//next will be pointing next node so this has to be type Node
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
    Node(int data,Node next)
    {
        this.data=data;
        this.next=next;
    }
}
public class SingleLinkedList {
    Node head=null;

    void insertAtBeg(int data){//Time complexity O(1)
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    void insertAtEnd(int data)//Time complexity O(n) because traversing the list until reach null
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

    public void insert(int num, int data) {
        Node tempNode=head;
        while(tempNode!=null && tempNode.data!=num){
            tempNode=tempNode.next;
        }
        Node newNode=new Node(data);
        newNode.next=tempNode.next;
        tempNode.next=newNode;

        //can't we change the order??No
        //If we first do tempNode.next=newNode then we lose the reference of tempNode.next and can't update the newNode.next

    }
    public void delete(int num){
        Node currNode=head;
        Node prevNode=null;
        while(currNode!=null && currNode.data!=num){
            prevNode=currNode;
            currNode=currNode.next;
        }
        if(currNode==head){
            if(head ==null)
            {
                System.out.println("List is empty");
                return;
            }
            head=head.next;//Deleting the first node;
            return;
        }
        prevNode.next=currNode.next;//Deleting intermediate or last node

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
