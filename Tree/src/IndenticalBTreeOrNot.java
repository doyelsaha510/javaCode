public class IndenticalBTreeOrNot {
    public static boolean ifSameStructure(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return ifSameStructure(node1.left, node2.left) && ifSameStructure(node1.right, node2.right);
    }
    public static boolean identicalOrnot(Node tree1,Node tree2){
        if(tree1 ==null && tree2==null)
            return true;
        if(tree1 ==null || tree2==null)
            return false;
        return tree1.data==tree2.data && identicalOrnot(tree1.left,tree2.left)
                                      && identicalOrnot(tree1.right,tree2.right);
    }
    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.left = new Node(7);

        Node root1 = new Node(5);
        root1.left = new Node(2);
        root1.right = new Node(6);
        root1.left.left = new Node(1);
        root1.left.right = new Node(4);
        root1.left.right.left = new Node(3);
        root1.right.right = new Node(8);
        root1.right.right.right = new Node(9);
        root1.right.right.left = new Node(7);

        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(6);
        root2.left.left = new Node(1);
        root2.left.right = new Node(4);;


        //System.out.println(identicalOrnot(root,root1));

        //System.out.println(identicalOrnot(root1,root2));
        System.out.println(ifSameStructure(root,root1));
    }
}
