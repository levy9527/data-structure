package problem;

public class Pi {
  /**
   * 通过概率求 pi 近似值
   * x^2 + y^2 <= 1 (r = 1)
   * pi = 4 * (inside/trials)
   * 结果不稳定，trials 数量更大不一定结果更精确，收敛速度也慢
   * @param trials 表示随机试验的总次数
   */
  public double monteCarlo(long trials) {
    double inside = 0;
    for (long i = 1; i <= trials; i++) {
      double x = Math.random();
      double y = Math.random();
      if (x * x + y * y <= 1) inside++;
    }

    return 4 * inside / trials;
  }

  /**
   * 公式法求近似值:
   * pi/2 = 1 + 1/3 + 1/3 * 2/5 +  1/3 * 2/5 * 3/7
   * 如何设置精度:
   * - 设置最终结果的小数位
   * - 设置公式项的阈值
   */
  public double formula() {
    double result = 1;
    int i = 1;
    double product = 1;

    while (product > 1e-16) {
      product = 1;

      for (double j = 1; j <= i; j++) {
        product *= j / (2 * j + 1);
      }

      result += product;
      i++;
    }
    return 2 * result;
  }

  public static void main(String[] args) {
    Pi pi = new Pi();
    System.out.println(pi.monteCarlo(100000));
    System.out.println(pi.monteCarlo(1000000));

    System.out.println(pi.formula());
  }
}
