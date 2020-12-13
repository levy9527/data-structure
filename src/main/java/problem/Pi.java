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

  public static void main(String[] args) {
    Pi p = new Pi();
    System.out.println(p.monteCarlo(100000));
    System.out.println(p.monteCarlo(1000000));
  }
}
