package algorithm;

/**
 * 逻辑上，要求的数，与已知数可通过层层递进推导出来。
 * 编程上，采用递归来完成。
 *
 * 递归具体又分为：顺推与逆推。
 * 顺推是根据已知条件，求问题结果；逆推是根据已知结果，求问题条件。
 */
public class Recursion {
  // 顺推
  public long fibonacci(int n) {
    if (n == 1 || n == 2) return 1;
    return fibonacci(n - 2) + fibonacci(n - 1);
  }

  // 感觉还是用代数计算更合适：不能死磕强推，应该用更适合自己的方法
  // 所以说，跨学科、数学很重要啊
  // 逆推
  public double deposit() {
    double moneyPerMonth = 1000.0;
    double rate = 0.0171 / 12;
    int months = 4 * 12 - 1;

    double result = moneyPerMonth;
    for (int i = months; i >= 1; i--) {
      result += moneyPerMonth;
      result /= (1 + rate);
    }

    return result;
  }

  public static void main(String[] args) {
    Recursion recursion = new Recursion();
    System.out.println(recursion.fibonacci(13));
    System.out.println(recursion.deposit());
  }
}
