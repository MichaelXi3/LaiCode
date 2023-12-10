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

 // Tree Recursion
// 1. What to expect from lchild and rchild
//  -> path sum from leaf to lchild & path sum from leaf to rchild
// 2. What do we want to do at curLevel
//  -> compute the maxPathSum from leaf to leaf & update maxPathSum when both lchild and rchild are not null
// 3. What to return to my parent node
//  -> Max straight path sum, either left or right

public class Solution {
  public int maxPathSum(TreeNode root) {
    if (root == null) return 0;
    int[] max = new int[]{Integer.MIN_VALUE};
    findMaxPathSum(root, max);
    return max[0];
  }

  private int findMaxPathSum(TreeNode root, int[] max) {
    // base case
    if (root == null) {
      return 0;
    }
    // subproblems
    int lPathSum = findMaxPathSum(root.left, max);
    int rPathSum = findMaxPathSum(root.right, max);
    // recursive rule
    if (root.left != null && root.right != null) {
      max[0] = Math.max(max[0], lPathSum + rPathSum + root.key);
    }
    // return to parent node
    if (root.left == null) {
      return rPathSum + root.key;
    }
    if (root.right == null) {
      return lPathSum + root.key;
    }
    return Math.max(lPathSum, rPathSum) + root.key;
  }
}

