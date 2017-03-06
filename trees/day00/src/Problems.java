import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> binaryTree(BinarySearchTree<Integer> bst,List<Integer> values, int low, int high){
        int middle = low + (high-low)/2;
        if(high<=low) return bst;
        else {
            bst.add(values.get(middle));
            binaryTree(bst, values, middle+1, high);
            binaryTree(bst, values, low, middle);
        }
        return bst;
    }

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        Collections.sort(values);
        return binaryTree(new BinarySearchTree<>(),values, 0, values.size());
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.key != n2.key) return false;

        return isIsomorphic(n1.leftChild, n2.leftChild) && isIsomorphic(n1.rightChild, n2.rightChild) ||
                isIsomorphic(n1.leftChild, n2.rightChild) && isIsomorphic(n1.rightChild, n2.leftChild);
    }

    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(4);
        al.add(6);
        al.add(5);

        minimalHeight(al);
    }
}
