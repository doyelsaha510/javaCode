import java.util.Stack;

public class SpiralOrder {
    public static void printInSpiralForm(Node node) {
        /* ------->---
                    |
           -----<----
           |
           ------>---
        * */
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(node);
        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                Node tmp = s1.pop();
                System.out.print(tmp.data + " ");

                if (tmp.left != null) {
                    s2.push(tmp.left);
                }

                if (tmp.right != null) {
                    s2.push(tmp.right);
                }
            }
            System.out.println();

            while (!s2.isEmpty()) {
                Node tmp = s2.pop();
                System.out.print(tmp.data + " ");

                if (tmp.right != null) {
                    s1.push(tmp.right);
                }

                if (tmp.left != null) {
                    s1.push(tmp.left);
                }
            }
            System.out.println();
        }
    }
    public static void printInSpiralFormRev(Node node) {
        /* ----------
           |
           ----->----
                    |
           ------<---
        * */
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(node);
        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                Node tmp = s1.pop();
                System.out.print(tmp.data + " ");

                if (tmp.right != null) {
                    s2.push(tmp.right);
                }

                if (tmp.left != null) {
                    s2.push(tmp.left);
                }
            }
            System.out.println();

            while (!s2.isEmpty()) {
                Node tmp = s2.pop();
                System.out.print(tmp.data + " ");

                if (tmp.left != null) {
                    s1.push(tmp.left);
                }

                if (tmp.right != null) {
                    s1.push(tmp.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.left = new Node(7);

        printInSpiralForm(root);
        System.out.println();
        printInSpiralFormRev(root);
    }
}
