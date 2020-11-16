package Problem3;

import Problem1.TreeNode;

public class InsertInBST {
    public static void insert(TreeNode<Integer> root, int valToInsert) {
        if (root.val > valToInsert && root.left == null) { //in the case that there is nothing left to traverse
            root.left = new TreeNode<>(valToInsert);
        } else if (root.val > valToInsert) { //otherwise if there is a root.left to traverse, keep going
            insert(root.left, valToInsert);
        } else if (root.val < valToInsert && root.right == null) { //same
            root.right = new TreeNode<>(valToInsert);
        } else if (root.val < valToInsert) {
            insert(root.right, valToInsert);
        } else { //if root value is equal to valToInsert, then just set root.left (or root.right) to a new TreeNode
            root.left = new TreeNode<>(valToInsert);
        }
    }
}
