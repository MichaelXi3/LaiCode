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
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode helper = root;

    while (helper != null || !stack.isEmpty()) {
      // inorder -> first go far left
      while (helper != null) {
        stack.offerFirst(helper);
        helper = helper.left;
      }
      // inorder -> record the middle node
      TreeNode mid = stack.pollFirst();
      res.add(mid.key);
      // inorder -> go to the right
      helper = mid.right;
    }
    return res;
  }
}
