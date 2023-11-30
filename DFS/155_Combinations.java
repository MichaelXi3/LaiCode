public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    // corner case
    if (n <= 0) {
      return res;
    }
    if (k <= 0) {
      res.add(new ArrayList<>());
      return res;
    }
    // DFS
    dfs(1, n, k, new ArrayList<>(), res);
    return res;
  }

  private void dfs(int start, int n, int k, List<Integer> cur, List<List<Integer>> res) {
    // base case
    if (cur.size() == k) {
      res.add(new ArrayList<>(cur));
      return;
    }
    // DFS logic
    for (int i = start; i <= n; i++) {
      cur.add(i);
      dfs(i + 1, n, k, cur, res);
      cur.remove(cur.size() - 1);
    }
  }
}

