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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<>();
        BSTToList(root, list);
        int prev = list.get(0);
        for (int i=1; i < list.size(); i++) {
            if (list.get(i) <= prev) return false;
            prev = list.get(i);
        }

        return true;
    }

    public void BSTToList(TreeNode root, List<Integer> list) {
        if (root == null) return;
        BSTToList(root.left, list);
        list.add(root.val);
        BSTToList(root.right, list);
    } 
}
