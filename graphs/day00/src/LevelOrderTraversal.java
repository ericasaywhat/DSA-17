import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<Integer> levelOrderTraversal(TreeNode<Integer> n) {
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            TreeNode<Integer> m = q.poll();
            l.add(m.key);
            if (m.hasLeftChild()) q.offer(m.leftChild);
            if (m.hasRightChild()) q.offer(m.rightChild);
        }
    return l;
    }
}
