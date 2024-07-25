package C3AIMedBT;


import com.sun.source.tree.Tree;

import java.util.*;

class Tuple {
    TreeNode node;
    int vertical;

    public Tuple(TreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}
public class BottomViewBT {

    public static List<Integer> bottomView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.offer(new Tuple(root, 0));

        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;


            if(!map.containsKey(vertical)){
                map.put(vertical, node.data);
            } else if (map.get(vertical) < node.data){
                map.put(vertical, node.data);
            }

            if(node.left != null) {
                queue.offer(new Tuple(node.left, vertical -1 ));
            }
            if(node.right != null) {
                queue.offer(new Tuple(node.right, vertical + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }


}
