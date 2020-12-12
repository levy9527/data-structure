package problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrimeNumber {
  /**
   * 素数：除了 1 和 自身，没有别的因子
   */
  boolean isPrimeNumber(int number) {
    // 则 2~n-1 进行求余
    if (number < 2) return false;
    boolean result = true;

//    for (int i = 2; i < number; i++) {
    // 定理：如果一个数是合数，那么它的最小质因数肯定小于等于他的平方根。
    // 使用 i * i 取代 sqrt(number) 操作
    for (int i = 2; i * i <= number; i++) {
      if (number % i == 0) {
        result = false;
        break;
      }
    }

    return result;
  }

  /**
   * 返回 2~number 范围内的所有素数
   */
  List<Integer> eratosthenes(int range) {
    int[] numbers = new int[range + 1];

    // 循环次数同样是 sqrt(number)
    for (int i = 2; i * i <= range; i++) {
      // 已经遍历过则 continue
      if (numbers[i] == 1) continue;
      for (int j = 2; i * j <= range; j++)
        numbers[i * j] = 1;
    }

    List<Integer> result = new LinkedList<>();
    for (int i = 2; i < range; i++) {
      if (numbers[i] == 0) result.add(i);
    }

    return result;
  }

  public static void main(String[] args) {
    PrimeNumber primeNumber = new PrimeNumber();
    int range = 1000;

    List<Integer> normal = new LinkedList<>();
    for (int i = 2; i <= range; i++)
      if (primeNumber.isPrimeNumber(i)) normal.add(i);
    System.out.println("--- normal method ---");
    System.out.println(Arrays.toString(normal.toArray()));

    System.out.println("---  sieve of Eratosthenes ---");
    System.out.println(Arrays.toString(primeNumber.eratosthenes(range).toArray()));
  }
}
