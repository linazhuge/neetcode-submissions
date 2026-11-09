/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> currNodes = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        List<Integer> currLevel = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        
        if (root == null) return list;
        currNodes.add(root);

        while (!currNodes.isEmpty()) {
            for (int i=0; i < currNodes.size(); i++) {
                TreeNode node = currNodes.get(i);
                currLevel.add(node.val);
                if (node.left != null) nextNodes.add(node.left);
                if (node.right != null) nextNodes.add(node.right);
            }

            list.add(currLevel);
            currNodes = nextNodes;
            nextNodes = new ArrayList<>();
            currLevel = new ArrayList<>();
        }
        
        return list;
    }
}
