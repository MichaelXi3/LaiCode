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
  public TreeNode flatten(TreeNode root) {
    // input validation check
    if (root == null) {
      return null;
    }
    postOrderTraversal(root);
    return root;
  }

  private void postOrderTraversal(TreeNode root) {
    // base case
    if (root == null) {
      return;
    }
    // subproblems
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    // recursive rule
    if (root.left != null) {
      TreeNode tmpRight = root.right;
      root.right = root.left;
      root.left = null;
      TreeNode iter = root.right;
      while (iter.right != null) {
        iter = iter.right;
      }
      iter.right = tmpRight;
    }
  }
}

