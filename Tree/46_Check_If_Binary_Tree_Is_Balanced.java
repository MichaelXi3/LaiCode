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
  public boolean isBalanced(TreeNode root) {
    // input validation check
    if (root == null) {
      return true;
    }
    return getHeightOrUnBalanced(root) == -1 ? false : true;
  }

  private int getHeightOrUnBalanced(TreeNode root) {
    // base case
    if (root == null) {
      return 0;
    }
    // subproblems
    int leftHeight = getHeightOrUnBalanced(root.left);
    int rightHeight = getHeightOrUnBalanced(root.right);
    // recursive rules
    // case 1: already unbalanced
    if (leftHeight == -1 || rightHeight == -1) {
      return -1;
    }
    // case 2: check current balance or not
    if (Math.abs(leftHeight - rightHeight) >= 2) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}

