public class BoundaryNodes {
    public static void doubleTree(Node node) {
        if (node == null) {
            return;
        }

        doubleTree(node.left);
        doubleTree(node.right);

        Node newNode = new Node(node.data);
        newNode.left = node.left;
        node.left = newNode;
    }
    public static void printBoundaryNodes(Node root){
        if (root!=null) {
            System.out.println(root.data + " ");

            printBoundaryNodesLeft(root.left);

            printLeavesNode(root.left);
            printLeavesNode(root.right);

            printBoundaryNodesRight(root.right);
        }
    }

    private static void printBoundaryNodesRight(Node node) {
        if(node==null){
            return;
        }
        if(node.right!=null){
            printBoundaryNodesRight(node.right);
            System.out.println(node.data+" ");
        }
        else if(node.left!=null){
            printBoundaryNodesRight(node.left);
            System.out.println(node.data+" ");
        }
    }

    private static void printLeavesNode(Node node) {
        if(node==null)
            return;
        printLeavesNode(node.left);
        if(node.left==null && node.right==null){
            System.out.println(node.data+" ");
        }
        printLeavesNode(node.right);
    }

    private static void printBoundaryNodesLeft(Node node) {
        if(node==null)
            return;
        if(node.left!=null){
            System.out.println(node.data+" ");
            printBoundaryNodesLeft(node.left);
        }else if(node.right!=null){
            System.out.println(node.data+" ");
            printBoundaryNodesLeft(node.right);
        }
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

        tree.inOrder(root);
        System.out.println();
        //printBoundaryNodes(root);
        doubleTree(root);
        tree.inOrder(root);


    }
}
