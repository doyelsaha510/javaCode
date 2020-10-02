import java.util.LinkedList;
import java.util.Queue;

public class SearchInBinaryTree {
    public static boolean RecursiveSearch(Node node,int key)
    {
        if (node==null)
            return false;
        if (node.data==key)
            return true;
            //System.out.println("found"+node.data);

        return RecursiveSearch(node.left,key)||RecursiveSearch(node.right,key);
    }
    public static boolean IterativeSearch(Node node,int key){
        if (node==null)
            return false;
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while (q.size()>0){
            Node temp=q.remove();
            if (temp.data==key)
                return true;
            if (temp.left!=null)
                q.add(temp.left);
            if (temp.right!=null)
                q.add(temp.right);
        }
        return false;
    }
    public static void main(String[] args) {
        TreeTraversal tree=new TreeTraversal();
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.left = new Node(7);

        boolean found=RecursiveSearch(root,6);
        if (found)
            System.out.println("found");
        else
            System.out.println("Not found");
        found=IterativeSearch(root,7);
        if (found)
            System.out.println("found");
        else
            System.out.println("Not found");
        found=RecursiveSearch(root,100);
        if (found)
            System.out.println("found");
        else
            System.out.println("Not found");


    }
}
