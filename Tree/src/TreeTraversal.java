import java.util.*;
import java.io.*;

class TreeTraversal {

/*
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            //System.out.println("data "+data+"root.data "+root.data);
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
                //System.out.println("cur "+cur.data+"root.left "+root.left);
            } else {
                cur = insert(root.right, data);
                root.right = cur;
                //System.out.println("cur "+cur.data+"root.right "+root.right);
            }
            return root;
        }
    }

    public static void preOrder(Node root) {
        //Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on of an expression tree
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void preOrderWithoutRecur(Node root){
        if(root==null)
            return;
        Stack<Node> s=new Stack<Node>();
        s.push(root);
        while(s.size()>0){
            Node temp=s.pop();
            System.out.println(temp.data+" ");
            if(temp.right!=null){//1st right beacause we are using stack lifo
                s.push(temp.right);
            }
            if(temp.left!=null){
                s.push(temp.left);
            }
        }
    }

    public static void postOrder(Node root) {
        //Postorder traversal is used to delete the tree. Please see the question for deletion of tree for details. Postorder traversal is also useful to get the postfix expression of an expression tree.
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static void postOrderWithoutRecur(Node root){
        if(root==null)
            return;
        Stack<Node> s1=new Stack<Node>();
        Stack<Node> s2=new Stack<Node>();
        s1.push(root);
        while(s1.size()>0){
            Node temp=s1.pop();
            if(temp.left!=null){
                s1.push(temp.left);
            }
            if(temp.right!=null){
                s1.push(temp.right);
            }
            s2.push(temp);
        }
        while (s2.size()>0){
            System.out.print(s2.pop().data+" ");
        }
    }
    public static void inOrder(Node root) {
        //Uses of Inorder
        //In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used.
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }
    public static void inOrderWithoutRecur(Node root){
        if(root==null)
            return;
        Stack<Node> s=new Stack<Node>();
        while(root!=null){
            s.push(root);
            root=root.left;
        }
        while(s.size()>0){
            Node temp=s.pop();
            System.out.println(temp.data+" ");
            if(temp.right!=null){
                Node righttemp=temp.right;
                while(righttemp!=null){
                    s.push(righttemp);
                    righttemp=righttemp.left;
                }
            }
        }
    }

    public static int height(Node root) {
        if (root == null)
            return -1;
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight > rightHeight)
                return leftHeight + 1;
            return rightHeight + 1;
        }
    }

    public static int sizeofTree(Node root) {
        if (root == null)
            return 0;
        else {
            return sizeofTree(root.left) + sizeofTree(root.right) + 1;
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {


            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

        }
    }
    public static void levelOrderSum(Node root){
        if (root==null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(true){
            int size= queue.size();
            if (size==0)
                break;
            int sum=0;
            while(size>0){
                Node temp=queue.remove();
                sum+=temp.data;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                size--;
            }
            System.out.println(sum);
        }
    }
    public static void printNodeBetwennGivenLevel(Node root,int min,int max){
        if (root==null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int l = 1;

        while (true) {
            int size = q.size();
            if (size == 0 || l > max) {
                break;
            }
            while (size > 0) {
                Node t = q.remove();
                if (l >= min && l <= max) {
                    System.out.print(t.data + " ");
                }
                if (t.left != null) {
                    q.add(t.left);
                }

                if (t.right != null) {
                    q.add(t.right);
                }

                size--;
            }
            l++;
        }
    }
    public int getMaximumElementAtAnyLevel(Node node) {
        if (node == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        int maxWidth = 1;

        while (true) {
            int size = q.size();
            if (size == 0) {
                break;
            }

            if (size > maxWidth) {
                maxWidth = size;
            }

            while (size > 0) {
                Node t = q.remove();

                if (t.left != null) {
                    q.add(t.left);
                }

                if (t.right != null) {
                    q.add(t.right);
                }
                size--;

            }
        }

        return maxWidth;
    }
    public static int getLevelofNode(Node root,int value,int level){
        if(root==null)
            return 0;
        int lvl;
        if (root.data==value){
            return level;
        }
        lvl=getLevelofNode(root.left,value,level+1);
        if (lvl!=0){
            return lvl;
        }
        lvl=getLevelofNode(root.right,value,level+1);

        return lvl;

    }
    public static int getSumofNodes(Node root) {
        if (root == null)
            return 0;
        else
            return root.data + getSumofNodes(root.left) + getSumofNodes(root.right);
    }

    public static int getDiffBetweenEvenAndOddLevel(Node root){
        if(root==null)
            return 0;
        return root.data-getDiffBetweenEvenAndOddLevel(root.left)-getDiffBetweenEvenAndOddLevel(root.right);
    }
    public static int getNumberOfLeafNodes(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return getNumberOfLeafNodes(root.left)+getNumberOfLeafNodes(root.right);
    }
    static void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++){
            printElementsAtGivelLevel(root, i);
            System.out.println();
        }
        System.out.println("------------------");
        for (i=h; i>=0; i--){
            printElementsAtGivelLevel(root, i+1);
            System.out.println();
        }

    }
    public static void printElementsAtGivelLevel(Node root,int level){
        if(root==null)
            return;
        if(level==1){
            System.out.print(root.data+" ");
        }
        else if (level > 1)
        {
            printElementsAtGivelLevel(root.left,level-1);
            printElementsAtGivelLevel(root.right,level-1);
        }

    }
    static  int maxLevel;
    public static void leftView(Node root,int level){
        if(root==null)
            return;
        if(level>=maxLevel){
            System.out.println(root.data+" ");
            maxLevel++;
        }
        leftView(root.left,level+1);
        leftView(root.right,level+1);
    }
    public static void topView(Node root){
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
        while(!q.isEmpty()){
            Node temp=q.remove();
            int hght=temp.height;

            if(map.get(hght)==null)
                map.put(hght,temp.data);

            if(temp.left!=null){
                temp.left.height=hght-1;
                q.add(temp.left);
            }

            if(temp.right!=null){
                temp.right.height=hght+1;
                q.add(temp.right);
            }
        }
        System.out.println(map.values());

    }

    public static void bottomView(Node root){
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
        while(!q.isEmpty()){
            Node temp=q.remove();
            int hght=temp.height;

            map.put(hght,temp.data);

            if(temp.left!=null){
                temp.left.height=hght-1;
                q.add(temp.left);
            }

            if(temp.right!=null){
                temp.right.height=hght+1;
                q.add(temp.right);
            }
        }
        System.out.println(map.values());

    }

    public static void rightView(Node root,int level){
        if(root==null)
            return;
        if(level>=maxLevel){
            System.out.println(root.data+" ");
            maxLevel++;
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        //System.out.println(getLevelofNode(root,4,1));
        //topView(root);
        bottomView(root);
        /*System.out.println("preOrder");
        preOrderWithoutRecur(root);
        preOrder(root);
        System.out.println();
        System.out.println("inOrder");
        inOrderWithoutRecur(root);
        inOrder(root);
        System.out.println();
        System.out.println("postOrder");
        postOrderWithoutRecur(root);
        System.out.println();
        postOrder(root);
        System.out.println();*/
        /*9
2 7 5 2 6 9 5 11 4*/
        //leftView(root,0);
        //rightView(root,0);
        /*printElementsAtGivelLevel(root,1);
        int leafNodes=getNumberOfLeafNodes(root);
        System.out.println("Leaf Nodes "+leafNodes);
        int diff=getDiffBetweenEvenAndOddLevel(root);
        System.out.println("getDiffBetweenEvenAndOddLevel "+diff);
        int sum = getSumofNodes(root);
        System.out.println("Sum " + sum);
        int h=height(root);
        System.out.println("height"+h);
        int size=sizeofTree(root);
        System.out.println("size "+size);
        System.out.println("preOrder");
        preOrder(root);
        System.out.println();
        System.out.println("inOrder");
        inOrder(root);
        System.out.println();
        System.out.println("postOrder");
        postOrder(root);
        System.out.println();
        */

        //System.out.println("levelOrder");
        //levelOrder(root);
        //printLevelOrder(root);

    }
}
