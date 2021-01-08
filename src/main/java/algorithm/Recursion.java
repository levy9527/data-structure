package algorithm;

/**
 * 逻辑上，要求的数，与已知数可通过层层递进推导出来。
 *
 * 递归具体又分为：顺推与逆推。
 * 顺推是根据已知条件，求问题结果；逆推是根据已知结果，求问题条件。
 */
public class Recursion {
  // 顺推
  // 同时也是递归：将问题化为一个缩小了的子问题（或规模更小的问题），函数调用自身
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

  // 因为主要操作是利用栈，则可以利用递归的形式：使用系统栈
  public String toBinary(int decimal) {
    if (decimal / 2 == 0) return String.valueOf(decimal % 2);

    return toBinary(decimal / 2) + decimal % 2;
  }

  public long hanoi(int disk) {
    if (disk <= 0) return 0;
    if (disk == 1) return 1;

    return 2 * hanoi(disk - 1) + 1;
  }

  public static void main(String[] args) {
    Recursion recursion = new Recursion();
    System.out.println(recursion.fibonacci(13));
    System.out.println(recursion.deposit());
    System.out.println(recursion.toBinary(121));

    System.out.println("--- hanoi ---");
    System.out.println(recursion.hanoi(2));
    System.out.println(recursion.hanoi(3));
    System.out.println(recursion.hanoi(8));
  }
}
