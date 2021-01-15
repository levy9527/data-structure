package problem;

public class Step {
  int howMuch() {
    int step = 7;
    while (true) {
      if (step % 2 == 1 &&
        step % 3 == 2 &&
        step % 5 == 4 &&
        step % 6 == 5
      ) break;
      else step += 7;
    }
    return step;
  }

  /**
   * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
   * 解题关键：假设其他台阶已经走完了，只剩下1个或2个台阶。
   */
  int countMethods(int steps) {
    if (steps <= 0) return 0;
    if (steps == 1) return 1;
    if (steps == 2) return 2;
    return countMethods(steps - 1) + countMethods(steps - 2);
  }


  public static void main(String[] args) {
    Step step = new Step();
    System.out.println(step.howMuch());
  }
}
