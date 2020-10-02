import java.util.Scanner;
import java.util.Stack;

public class PalindromeOrNot {
    private static Node slow, fast, second_half,first_half;
    private static Node head, left;

    public static boolean isPalindromWithStack(Node head){
        /*A simple solution is to use a stack of list nodes. This mainly involves three steps.
        Traverse the given list from head to tail and push every visited node to stack.
        Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
        If all nodes matched, then return true, else false.*/
        Node slow=head;
        Stack<Integer> stack=new Stack<Integer>();
        boolean isPalindrome=true;
        while(slow!=null){
            stack.push(slow.data);
            slow=slow.next;
        }
        while (head!=null){
            int i=stack.pop();
            if(head.data == i){
                isPalindrome=true;
            }
            else{
                isPalindrome=false;
                break;
            }
            head=head.next;
        }
        return isPalindrome;

    }
    public static boolean isPalindromWithSplitAndReverse(Node head){
        /*1.Split the linked List in the middle
        * 2.Prepare two linked List
        * 3.If odd ignore the middle node
        * 4.Reverse the second Linked list
        * 5.Compare the two Linked Lists*/
        slow=head;
        fast=head;
        boolean isPalindrome=true;
        if(head ==null || head.next==null){
            isPalindrome=true;
            return isPalindrome;
        }

        while (true){
            fast=fast.next.next;
            //System.out.println("yoo");
            if(fast==null){
                second_half=slow.next;
                break;
            }
            if(fast.next==null){
                second_half=slow.next.next;
                break;
            }
            slow=slow.next;
        }
        slow.next=null;
        System.out.println("Second LL starts from "+second_half.data);
        second_half= MergeTwoSortedLL.reverse(second_half);
        first_half=head;
        System.out.println("First Half LL");
        printList(first_half);
        System.out.println("Second Half LL");
        printList(second_half);
        while (first_half!=null && second_half !=null){
            if(first_half.data ==second_half.data){

                first_half=first_half.next;
                second_half=second_half.next;
            }
            else{
                isPalindrome=false;
                break;
            }
        }
        return isPalindrome;
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
        //printList(firstlist);
        //boolean isPalindromeList=isPalindromWithStack(firstlist);
        boolean isPalindromeList=isPalindromWithSplitAndReverse(firstlist);

        if(isPalindromeList){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


    }
}
