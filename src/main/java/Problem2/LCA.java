package Problem2;

import Problem1.TreeNode;

public class LCA {
    public static TreeNode<Integer> answer;

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p,
                                                         TreeNode<Integer> q)
    {
        if (root == null) { //in the case that it is not found
            return null;
        }

        //search for the nodes that are equal to either p or q
        if (root == p || root == q) {
            return root;
        }

        //continue to traverse nodes until reach the end or find a match with p or q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //once this is done, it returns the left and right of a node, now we will now check them

        //if both are not equal to null, then LCA is found
        if (left != null && right != null) {
            return root;
        }

        //return the node that is not null
        if (left != null) {
            return left;
        } else { //if right is not null
            return right;
        }
    }
}