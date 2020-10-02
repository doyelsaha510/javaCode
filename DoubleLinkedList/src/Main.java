public class Main {
    public static void main(String[] args) {
        DoubleLinkedList dlist=new DoubleLinkedList();
        dlist.insertAtBeg(78);
        dlist.insertAtBeg(954);
        dlist.insertAtEnd(45);
        dlist.insertAtBeg(900);
        dlist.insertAtEnd(458);
        dlist.printList();
        dlist.insert(78,999);
        dlist.printList();
        try {
            dlist.delete(45);
            dlist.printList();
            dlist.delete(900);
            dlist.printList();
            dlist.delete(458);
            dlist.printList();
            dlist.delete(45);
            dlist.printList();
        }catch (Exception e){
            System.out.println("Not is the list");
        }

    }
}
