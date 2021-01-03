package problem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 关键是：
 * 1.运算数直接输出（按字符串顺序即可）；
 * 2.运算符入栈，优先级高的可以压优先级低的栈；
 * 3.括号不计优先级，左括号一路压栈，遇到右括号，一直出栈，直到把一个左括号也出栈
 * 4.字符串遍历过后，把栈下剩余元素全部出栈
 */
public class ReversePolishNotation {
  private int getPriority(char ch) {
    if (ch == '+' || ch == '-') return 1;
    if (ch == '*' || ch == '/') return 2;
//    if (ch == '(' || ch == ')') return 4;
    return 0;
  }
  public String postFix(String expression) {
    StringBuilder builder = new StringBuilder();

    List<Character> operators = new ArrayList<>(4);
    operators.add('+');
    operators.add('-');
    operators.add('*');
//    operators.add('/');
//    operators.add('(');
    // 栈顶优先级高，则先出栈

    Deque<Character> stack = new LinkedList<>();

    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      // 过滤空格
      if (ch == ' ') continue;

      if (operators.contains(ch)) {
        while (stack.peekFirst() != null &&
          getPriority(stack.peekFirst()) > getPriority(ch)) {
          // 出栈
          builder.append(stack.pollFirst());
        }
        stack.offerFirst(ch);
      }
      else if (ch == '(') {
        stack.offerFirst(ch);
      }
      else if (ch == ')') {
        while (stack.peekFirst() != '(')
          builder.append(stack.pollFirst());
        stack.pollFirst();
      }
      else builder.append(ch);
    }

    // 多位数
    while (stack.size() > 0) {
      builder.append(stack.pollFirst());
    }

    return builder.toString();
  }
  public static void main(String[] args) {
    ReversePolishNotation RPN = new ReversePolishNotation();
    System.out.println(RPN.postFix("a+b"));
    System.out.println(RPN.postFix("a*b+c"));
    System.out.println(RPN.postFix("a+b*c"));
    System.out.println(RPN.postFix("((a*b)+c)"));
    System.out.println(RPN.postFix("(a*(b+c))"));
    System.out.println(RPN.postFix("(a+b) * (c+d)"));
    System.out.println(RPN.postFix("(12+34) * (11+5)"));
  }
  // stack   + b+ ab+
  // array a

  // stack   * b* ab* ab* +  c+ ab*c+
  // array a              ab*

  // stack * cd+* ab+cd+*
  // array: ab+

  // 括号应该是分治，看成递归调用
  // stack: b*a(( +( c+( )c+(
  // sub： a*b +c

  // stack: )c+b(*a( )*a(
  // sub: b+c a*

  // stack )b+a( )d+c(* * ab+cd+*
  // sub a+b c+d => ab+ cd+
}
