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
   * 关键思路：寻找数列 n 与 n+1 之间的规律，则：V(n + 1) = V(n) * 分子/分母，由此可以设置一个变量作为中间结果随着循环而变化
   * 如何设置精度:
   * - 设置最终结果的小数位
   * - 设置公式项的阈值
   */
  public double formula() {
    double result = 2;
    double product = 2;
    double numerator = 1, denominator = 3;

    // 受 double 精度限制
    while (product > 1e-16) {
      product *= numerator/denominator;
      result += product;
      numerator++;
      denominator += 2;
    }
    return result;
  }

  /**
   * 使用数组存储数字,
   * 把分数变成：先做乘法，再做除法
   * @param length 表示要精确的长度
   */
  public String formulaEnhance(int length) {
    if (length < 1) return "";

    int[] result = new int[length];
    int[] product = new int[length];
    result[0] = 2;
    product[0] = 2;

    int numerator = 1, denominator = 3;

    // 精度退出条件
    for (int t = 0; t < Math.min(length,Integer.MAX_VALUE); t++) {
      int carry = 0;

      // 由（数字的）低位到高位进行乘法
      for (int i = length - 1; i >= 0; i--) {
        int temp = product[i] * numerator + carry;
        product[i] = temp % 10;
        carry = temp / 10;
      }

      // 由（数字的）高位到低位进行除法
      carry = 0;
      for (int i = 0; i < length; i++) {
        int temp = product[i] + carry * 10;
        product[i] = temp / denominator;
        carry = temp % denominator;
      }

      // 加法及进位
      carry = 0;
      for (int i = length -1; i >= 0; i--) {
        // 程序逻辑上 i = 0 时，进位丢失了；但实际上不会出现这种情况
        int temp = result[i] + product[i] + carry;
        result[i] = temp % 10;
        carry = temp / 10;
      }

      numerator++;
      denominator +=2;

    }

    StringBuilder builder = new StringBuilder();
    builder.append(result[0]);
    builder.append('.');

    for (int i = 1; i < length; i++) {
      if (i > 2 && (i - 1) % 10 == 0) builder.append(' ');
      builder.append(result[i]);
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    Pi pi = new Pi();
    System.out.println(pi.monteCarlo(100000));
    System.out.println(pi.monteCarlo(1000000));

    System.out.println(pi.formula());

    System.out.println(pi.formulaEnhance(1000));
  }
}
