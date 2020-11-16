package ExtraCredit;

import Problem1.TreeNode;

import java.util.*;

//used as reference to solve: https://www.youtube.com/watch?v=nPtARJ2cYrg

//used to look up what to use, used hashmap and hashset:
//https://www.geeksforgeeks.org/difference-between-hashmap-and-hashset/
//https://www.youtube.com/watch?v=jwtx6GVPdyw

public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        //pseudocode:
        // we should check the target nodes parent (to check the other child if there is one, and continue to
        // traverse that other side) and target's child nodes.
        // Breadth first search would be appropriate in this situation, we want to check each level
        // Keep track of each node's parent node
        // Have a queue since we are doing BFS
        // start with target node in queue
        // Poll that node from queue so we can check parent and child node, add to the queue
        // Keep track of visited nodes so we don't reinsert into queue
        // Continue to poll each item in queue and insert its parent and children nodes into queue
        // with each polling and adding, that is one iteration
        // once the number of iterations matches the number of levels (k) then return the values
        //that are in the queue
        // Use hash table to keep track of parent of a node
        // Every node will be the key, and corresponding parent will be the value


        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        makeMap(parentMap, root, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> duplicate = new HashSet<>(); //keep track of duplicates
        q.add(target); //start it off by adding target node, find levels k based on target
        duplicate.add(target);
        int level = 0;
        List<Integer> toReturn = new ArrayList<>(); //to store the values that are k distance away

        while (!q.isEmpty()) {
            int size = q.size(); // so we can poll for each item in queue
            if (level == k) { //once the level is equal to the k distance, we can just retrieve the numbers
                while (!q.isEmpty()) { //build the list to return
                    Integer toAdd = (Integer)q.poll().val;
                    toReturn.add(toAdd);
                }
                return toReturn;
            }
            for (int i = 0; i < size; i++) { //for each set of number in the queue
                TreeNode node = q.poll();

                //for children nodes
                if (node.left != null && !duplicate.contains(node.left)) { //if there is something to the left,
                    q.add(node.left);                                   //and it is not a duplicate
                    duplicate.add(node.left);
                }

                if (node.right != null && !duplicate.contains(node.right)) {
                    q.add(node.right);
                    duplicate.add(node.right);
                }

                //for parent node
                TreeNode parent = parentMap.get(node); //get corresponding parent node
                if (parent != null && !duplicate.contains(parent)) { //if the parent was not already visited
                    q.add(parent);
                    duplicate.add(parent);
                }
            }
            level++; //go to next level
        }
        return toReturn;
    }


    private static void makeMap(Map<TreeNode, TreeNode> parentMap,
                                TreeNode node, TreeNode parentNode)
    {
        if (node == null) {
            return; //base condition, do nothing
        }
        parentMap.put(node, parentNode); //set each node and its parent paired together
        makeMap(parentMap, node.left, node); //call recursively so we can do it for all nodes
        makeMap(parentMap, node.right, node);
    }
}
