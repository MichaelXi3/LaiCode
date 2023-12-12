/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode reverse(TreeNode root) {
    // base case
    if (root == null || root.left == null) {
      return root;
    }
    // subproblem
    TreeNode newRoot = reverse(root.left);
    // recursive rules
    root.left.left = root;
    root.left.right = root.right;
    root.left = null;
    root.right = null;
    return newRoot;
  }
}

