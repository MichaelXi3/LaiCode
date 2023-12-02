public class Solution {

  // clarification
    // input: String input
    // output: List<String> of all permutation
  // assumption: input string is not null

  public List<String> permutations(String input) {
    List<String> res = new ArrayList<>();
    char[] inputs = input.toCharArray();
    dfs(0, inputs, res);
    return res;
  }

  private void dfs(int curIndex, char[] inputs, List<String> res) {
    // base case
    if (curIndex == inputs.length) {
      res.add(new String(inputs));
      return;
    }
    // recursive rules and subproblems
    Set<Character> visited = new HashSet<>();
    for (int i = curIndex; i < inputs.length; i++) {
      if (visited.add(inputs[i])) {
        swap(inputs, curIndex, i);
        dfs(curIndex + 1, inputs, res);
        swap(inputs, curIndex, i);
      }
    }
  }

  private void swap(char[] inputs, int i, int j) {
    char tmp = inputs[i];
    inputs[i] = inputs[j];
    inputs[j] = tmp;
  }
}

