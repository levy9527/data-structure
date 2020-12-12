package problem;

import java.util.ArrayList;
import java.util.List;

public class Factorial {
  private long number;
  private List<Long> numbers;

  @Deprecated
  Factorial() {
  }

  public Factorial(long number) {
    this.number = number;
    this.numbers = getFactorial(number);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();

    for (int i = numbers.size() - 1; i >= 0; i--) {
      result.append(numbers.get(i));
    }

    return result.toString();
  }

  /**
   *
   // 把数字使用数组存储, 低位对应数组的低位，如 123, 数组为 [3,2,1]
   // 循环进行求积
   // 数组元素 >= 10 则向高位进位
   */
  private List<Long> getFactorial(long number) {

    List<Long>  numbers = new ArrayList<>();
    long remain = number;

    while (remain != 0) {
      numbers.add((remain % 10));
      remain /= 10;
    }

    for (long factor = number - 1; factor >= 2; factor--) {
      for (int i = 0; i < numbers.size(); i++) {
        long value = numbers.get(i);
        long product = value * factor;
        numbers.set(i, product);
      }

      // 处理进位
      // 数组的长度在变化，故不能用类似 len = numbers.size() 的语句作为循环结束条件
      for (int i = 0; i < numbers.size(); i++) {
        long value = numbers.get(i);

        int step = 1;
        if (value >= 10)  {
          numbers.set(i, value % 10);
          value /= 10;

          while (value != 0) {
            if (i + step < numbers.size()) numbers.set(i + step, value % 10 + numbers.get(i + step));
            else numbers.add(value % 10);

            value /= 10;
            step++;
          }
        }
      }
    }

    return numbers;

  }




  /**
   * @deprecated
   * @param n 当 n
   */
  int factorialNormal(int n) {
    if (n >= 13) throw new RuntimeException("the result will be out of int range");
    if (n < 1) throw new RuntimeException("n must larger than 1");
    if (n == 1) return 1;
    return n * factorialNormal(n - 1);
  }

  public static void main(String[] args) {
    Factorial f = new Factorial();
    System.out.println(f.factorialNormal(12));


    Factorial factorial = new Factorial(200);
    System.out.println(factorial);
  }
}
