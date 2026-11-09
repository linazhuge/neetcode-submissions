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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (containsNode(root.left, p) && containsNode(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (containsNode(root.right, p) && containsNode(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public boolean containsNode(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root.val == p.val) return true;
        return containsNode(root.left, p) || containsNode(root.right, p);
    }
}
