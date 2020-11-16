package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while(current != null) { //go the leftmost node
                stack.push(current);
                current = current.left;
            }
            //once at the very leftmost node, add to the result
            current = stack.pop();
            result.add((Integer)current.val);
            current = current.right; //go to the right node now
        }
        return result;
    }
}
