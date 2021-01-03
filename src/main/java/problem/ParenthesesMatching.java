package problem;

import java.util.*;

public class ParenthesesMatching {
  /**
   * @param str 待检测字符串
   * @return 如果匹配，则返回 "", 否则返回不匹配的位置
   */
  private Integer[] match(String str) {
    // 遍历字符串，左括号压栈，右括号弹栈
    Deque<Integer> stack = new ArrayDeque<>();
    List<Character> leftParentheses = new ArrayList<>(3);
    leftParentheses.add('(');
    leftParentheses.add('[');
    leftParentheses.add('{');

    List<Character> rightParentheses = new ArrayList<>(3);
    rightParentheses.add(')');
    rightParentheses.add(']');
    rightParentheses.add('}');

    for (int i = 0; i < str.length(); i++) {
      // 使用 charAt 而不是 codePoints 并无所谓，因为括号一定是能用 charAt 检测到
      char ch = str.charAt(i);
      if (leftParentheses.contains(ch))
        stack.offerFirst(i);
      else if (rightParentheses.contains(ch))
        stack.pollFirst();
    }

    if (stack.size() == 0) return null;
    // 如果能接受逆序，就用这句
//    else return stack.toArray(new Integer[0]);
    else {
      List<Integer> results = new ArrayList<>(stack.size());

      while (stack.size() > 0) {
        results.add(stack.pollLast());
      }

      return results.toArray(new Integer[0]);
    }
  }

  public static void main(String[] args) {
    ParenthesesMatching parentheses = new ParenthesesMatching();

    String isMatch = "(x+y)*(x-y)";
    String notMatch = "(a+(b+c)*d*(d*e)*(f-e";
    System.out.println(Arrays.toString(parentheses.match(isMatch)));
    System.out.println(Arrays.toString(parentheses.match(notMatch)));
  }

}
