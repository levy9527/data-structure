package problem;

import java.util.List;

public class Goldbach {
  public static void main(String[] args) {
    int range = 1000;
    StringBuilder result = new StringBuilder();

    // 先筛选出所有素数
    // 再从 i = 4 开始，找出在范围内偶数 i 满足 i = a + b， 其中 a, b 均为素数
    // 最后输出

    PrimeNumber primeNumber = new PrimeNumber();
    List<Integer> primes = primeNumber.eratosthenes(1000);

    for (int i = 4; i <= range; i += 2) {

      for (int prime : primes) {
        if (prime > i / 2) break;
        int minus = i - prime;

        // 差也是素数，需要记录
        if (primes.indexOf(minus) > -1) {
          result.append(i);
          result.append("=");
          result.append(prime);
          result.append("+");
          result.append(minus);
          result.append("\n");
          // 只记录一对即可
          break;
        }
      }
    }

    System.out.println(result.toString());
  }
}
