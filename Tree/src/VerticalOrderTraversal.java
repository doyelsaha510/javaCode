import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    public static void printVerticalOrder(Node node){
        if (node == null) {
            return;
        }
        int hd = 0;

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<Integer, ArrayList<Integer>>();

        getVerticalOrder(node, hd, m);

        for (Map.Entry<Integer, ArrayList<Integer>> cm : m.entrySet()) {
            System.out.println(cm.getValue());
        }

    }

    private static void getVerticalOrder(Node node, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
        if (node == null) {
            return;
        }

        if (m.get(hd) == null) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(node.data);
            m.put(hd, l);
        } else {
            ArrayList<Integer> l = m.get(hd);
            l.add(node.data);
            m.put(hd, l);
        }

        getVerticalOrder(node.left, hd - 1, m);
        getVerticalOrder(node.right, hd + 1, m);
    }
    private static void printVerticalSum(Node node){
        if (node==null)
            return;
        TreeMap<Integer, Integer> mapsum=new TreeMap<Integer, Integer>();
        getVerticalOrderSum(node,0,mapsum);

        System.out.println(mapsum.values());

    }
    private static void getVerticalOrderSum(Node node,int height,Map<Integer,Integer> map){
        if (node==null){
            return;
        }
        getVerticalOrderSum(node.left,height-1,map);

        int sum=(map.get(height)==null) ? 0 :map.get(height);
        map.put(height,sum+node.data);

        getVerticalOrderSum(node.right,height+1,map);
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

        //printVerticalOrder(root);
        //printVerticalSum(root);
        //tree.levelOrder(root);
        //tree.levelOrderSum(root);
        //tree.printNodeBetwennGivenLevel(root,2,3);
        System.out.println(tree.getMaximumElementAtAnyLevel(root));
    }
}
