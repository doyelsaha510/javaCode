
public class BTToMirrorTree {
    public static boolean ifIsomorphic(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.data != node2.data) {
            return false;
        }

        return (ifIsomorphic(node1.left, node2.left) && ifIsomorphic(node1.right, node2.right))
                || (ifIsomorphic(node1.left, node2.right) && ifIsomorphic(node1.right, node2.left));
    }
    public static boolean ifFoldableTree(Node node) {
        if (node == null) {
            return true;
        }

        return ifMirrorStructureTree(node.left, node.right);
    }
    public static boolean ifMirrorStructureTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return ifMirrorStructureTree(node1.left, node2.right) && ifMirrorStructureTree(node1.right, node2.left);
    }
    public static boolean ifTwoTreeIsMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node2.data
                && ifTwoTreeIsMirror(node1.left, node2.right)
                && ifTwoTreeIsMirror(node1.right, node2.left);
    }
    public static Node MirrorTree(Node root){
        if(root==null)
            return null;

        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        MirrorTree(root.left);
        MirrorTree(root.right);
        return root;
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

        //tree.inOrder(root);
        //System.out.println();
        //Node mirror=MirrorTree(root);
        //tree.inOrder(mirror);
        Node root1 = new Node(2);
        root1.left = new Node(7);
        root1.right = new Node(8);
        root1.left.left = new Node(5);

        Node root2 = new Node(2);
        root2.left = new Node(8);
        root2.right = new Node(7);
        root2.right.right = new Node(5);

        Node root3 = new Node(2);
        root2.left = new Node(8);
        root2.right = new Node(7);
        root1.left.left = new Node(6);
        root2.right.right = new Node(5);


        //boolean found=ifTwoTreeIsMirror(root1,root2);
        boolean found=ifMirrorStructureTree(root1,root2);
        if (found)
            System.out.println("Yes Mirror");
        else
            System.out.println("No Mirror");

        System.out.println("Foldable tree  "+ifFoldableTree(root3));
        System.out.println("Isomorphic tree  "+ifIsomorphic(root3,root2));

    }
}

