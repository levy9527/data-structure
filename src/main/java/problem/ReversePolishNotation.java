package problem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 关键是：
 * 1.运算数直接输出（按字符串顺序即可）；
 * 2.运算符入栈，优先级高的可以压优先级低的栈，否则要把操作符先出栈（同等级也要先出栈，否则顺序就乱了），再把新的操作符入栈
 * 3.括号不计优先级，左括号一路压栈，遇到右括号，一直出栈，直到把一个左括号也出栈
 * 4.字符串遍历过后，把栈下剩余元素全部出栈
 */
public class ReversePolishNotation {
  private List<Character> operators;

  public ReversePolishNotation() {
    List<Character> operators = new ArrayList<>(4);
    operators.add('+');
    operators.add('-');
    operators.add('*');
    operators.add('/');
    this.operators = operators;
  }

  private int getPriority(char ch) {
    if (ch == '+' || ch == '-') return 1;
    if (ch == '*' || ch == '/') return 2;
//    if (ch == '(' || ch == ')') return 4;
    return 0;
  }
  public String postFix(String expression) {
    StringBuilder builder = new StringBuilder();

    Deque<Character> stack = new LinkedList<>();

    boolean isPrevNumber = false;

    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      // 过滤空格
      if (ch == ' ') continue;

      if (operators.contains(ch)) {
        while (stack.peekFirst() != null &&
          getPriority(stack.peekFirst()) >= getPriority(ch)) {
          // 出栈
          builder.append(stack.pollFirst());
        }
        stack.offerFirst(ch);

        if (isPrevNumber) {
          builder.append(',');
        }
        isPrevNumber = false;
      }
      else if (ch == '(') {
        isPrevNumber = false;
        stack.offerFirst(ch);
      }
      else if (ch == ')') {
        isPrevNumber = false;
        while (stack.peekFirst() != '(')
          builder.append(stack.pollFirst());
        stack.pollFirst();
      }
      else {
        isPrevNumber = true;
        builder.append(ch);
      }
    }

    while (stack.size() > 0) {
      builder.append(stack.pollFirst());
    }

    return builder.toString();
  }

  // 关键点是：1.解析数字 2.执行运算 3.注意小数部分
  public long eval(String postFix) {
    // TODO 小数部分
    String numChar = "";
    Deque<Long> numbers = new LinkedList<>();
    boolean isPrevNumber = false;

    for (int i = 0; i < postFix.length(); i++) {
      char ch = postFix.charAt(i);
      if (ch == ',' || operators.contains(ch)) {
        if (isPrevNumber) {
          long number = Long.parseLong(numChar);
          numbers.offerFirst(number);
        }

        if (ch != ',') {
          long x = numbers.size() > 0 ? numbers.pollFirst() : 0;
          long y = numbers.size() > 0 ? numbers.pollFirst() : 0;
          long result = 0;

          if (ch == '+') result = x + y;
          else if (ch == '-') result = x - y;
          else if (ch == '*') result = x * y;
          else result = x / y;

          numbers.offerFirst(result);
        }

        numChar = "";
        isPrevNumber = false;
      }
      else {
        numChar += ch;
        isPrevNumber = true;
      }

    }

    if (numbers.size() > 1) throw new RuntimeException("表达式不正确");

    return numbers.size() > 0 ? numbers.pollFirst() : 0;
  }
  public static void main(String[] args) {
    ReversePolishNotation RPN = new ReversePolishNotation();
    System.out.println(RPN.postFix("a+b")); // a,b+
    System.out.println(RPN.postFix("a*b+c")); // a,b*,c+
    System.out.println(RPN.postFix("a+b*c")); // a,b,c*+
    System.out.println(RPN.postFix("a/b*c")); // a,b/,c*
    System.out.println(RPN.postFix("((a*b)+c)")); // a,b*c+
    System.out.println(RPN.postFix("(a*(b+c))")); // a,b,c+*
    System.out.println(RPN.postFix("(a+b) * (c+d)")); // a,b+c,d+*
    System.out.println(RPN.postFix("(12+34) * (11+5)")); // 12,34+11,5+*

    System.out.println(RPN.eval(RPN.postFix("(12+34) * (11+5)"))); // 12,34+11,5+*
  }
}
