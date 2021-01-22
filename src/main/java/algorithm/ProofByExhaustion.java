package algorithm;

import problem.ReversePolishNotation;

/**
 * 将所有的候选答案逐一取出，并验证该候选答案是否为正确的解
 */
public class ProofByExhaustion {
  private void swap(char[] a, int x, int y) {
    char t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  public String fiveFivesToFive() {
    // 使用四则运算符（各使用一次），使用以下等式成立
    System.out.println("question: 5 ? 5 ? 5 ? 5 ? 5 = 5");
    StringBuilder builder = new StringBuilder("answer: \n");
    char[] operators = {'+', '-', '*', '/'};
    ReversePolishNotation RPN = new ReversePolishNotation();

    int count = 0;

    // TODO 关键是排列组合，相应代码老是写不对!
    for (int i = 0; i < operators.length; i++) {
      for (int j = 1; j < operators.length; j++) {
        for (int k = 2; k < operators.length; k++) {
          StringBuilder operation = new StringBuilder();
          operation.append(5);
          operation.append(operators[0]);
          operation.append(5);
          operation.append(operators[1]);
          operation.append(5);
          operation.append(operators[2]);
          operation.append(5);
          operation.append(operators[3]);
          operation.append(5);

//          if (RPN.eval(operation.toString()) == 5) {
            builder.append(++count);
            builder.append(". ");
            builder.append(operation.toString());
            builder.append('\n');
//          }
          swap(operators, 2, 3);
        }

        swap(operators, 1, j);
      }
      swap(operators, 0, 1);
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    ProofByExhaustion proofByExhaustion = new ProofByExhaustion();
    System.out.println(proofByExhaustion.fiveFivesToFive());
  }
}
