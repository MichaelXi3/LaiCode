public class Solution {
  public boolean canBreak(String input, String[] dict) {
    
    // dp meaning: dp[i] represents WON the substring (0, i) canBreak
    // base case: dp[0] = true (empty string case)
    // induction step
      // for all substrings from 0 to i, try all break points, stop at first success
      // left part dp[j] and right part is substring(j, i), check right part for WON in dict
    // return: dp[input.length]

    boolean[] dp = new boolean[input.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= input.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && isContained(dict, input.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[input.length()];
  }

  private boolean isContained(String[] dict, String str) {
    for (String word : dict) {
      if (word.equals(str)) {
        return true;
      }
    }
    return false;
  }
}

