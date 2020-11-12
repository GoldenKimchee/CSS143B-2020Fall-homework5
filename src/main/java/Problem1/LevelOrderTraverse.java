package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { //there is no work to do
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); //starts the while loop
        while (!queue.isEmpty()) { //continues as long as there are items in the lower levels
            int size = queue.size(); //set up the upcoming for loop to only go through items in current level
            List<Integer> oneResult = new ArrayList<>();
            for (int i = 0; i < size; i++) { //add items from queue into oneResult list only for the current level
                TreeNode current = queue.poll(); //stored to find the children (next level)
                oneResult.add((Integer)current.val);
                if (current.left != null) {
                    queue.add(current.left); //to be added to oneResult list in the next iteration in this while loop
                }
                if (current.right != null) {
                    queue.add(current.right); //same
                }
            }
            result.add(oneResult); //after one iteration of the while loop, add this oneResult to the result
        }
        return result;
    }
}
