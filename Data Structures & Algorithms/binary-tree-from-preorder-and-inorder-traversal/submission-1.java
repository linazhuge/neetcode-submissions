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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);

        ArrayList<Integer> leftP = new ArrayList<>();
        ArrayList<Integer> rightP = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();

        int i = 0;
        for (;i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) break;
            leftP.add(inorder[i]);
            map.add(inorder[i]);
        }

        i++;

        for (;i < inorder.length; i++) {
            rightP.add(inorder[i]);
        }

        int [] leftI = new int [leftP.size()];
        int [] rightI = new int [rightP.size()];

        int left = 0;
        int right = 0;

        for (int j=1; j < preorder.length; j++) {
            if (map.contains(preorder[j])) {
                leftI[left] = preorder[j];
                left++;
            } else {
                rightI[right] = preorder[j];
                right++;
            }
        }

        node.left = buildTree(leftI, leftP.stream()
                        .mapToInt(Integer::intValue)
                        .toArray());
        node.right = buildTree(rightI, rightP.stream()
                        .mapToInt(Integer::intValue)
                        .toArray());

        return node;
    }
}
