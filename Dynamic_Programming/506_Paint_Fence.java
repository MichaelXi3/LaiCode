public class Solution {
  // Clarification
    // Input: n posts, k colors
    // Output: total number of paint ways
  // Assumption
    // n and k are non-negative integers
    // at most 2 adjacent posts can have the same color 
  // Result
    // dp[i] is the total number of ways to paint i length fence with k colors
    // case 1: paint a different color to previous one
      // dp[i-1] * (k-1)
    // case 2: paint a same color as the previous one
      // the prev post and the prev-prev post must not have the same color
      // dp[i-2] * (k-1)
    // thus, dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k-1) for i >= 3
  // Test - don't forget to go through a test case before submission!
  public int numWays(int n, int k) {
    // corner cases
    if (n <= 0) return 0;
    if (n == 1) return k;
    // dp base cases
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = k;
    dp[2] = k * k;
    // dp induction
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
    }
    return dp[n];
  }
}

