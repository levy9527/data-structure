package problem;

import java.util.*;

public class PrimeNumber {
  /**
   * 素数：除了 1 和 自身，没有别的因子
   */
  public boolean isPrimeNumber(int number) {
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
  public List<Integer> eratosthenes(int range) {
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

  public long sumPrime(int range) {
    long sum = 0;
    List<Integer> primes = eratosthenes(range);

    for (Integer prime : primes)
      sum += prime;

    return sum;
  }


  private Set<Integer> factors = new HashSet<>();
  private List<Integer> formula = new LinkedList<>();

  public Integer[] factorization(int number) {
    List<Integer> primes = this.eratosthenes(number);

    // 判断是否其因子
    for (Integer prime : primes) {
      if (number % prime == 0) {
        factors.add(prime);
        formula.add(prime);

        Integer quotient = number / prime;

        // 如果商也是质数，则说明已分解完毕，否则对商进行分解
        if (primes.contains(quotient)) {
          factors.add(quotient);
          formula.add(quotient);
        }
        else {
          this.factorization(quotient);
        }
        break;
      }
    }

    return factors.toArray(new Integer[0]);
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

    System.out.println("--- sum of primes within 100 ---");
    System.out.println(primeNumber.sumPrime(100));

    System.out.println("--- factorization ---");
    int number = 28;
    System.out.println(Arrays.toString(primeNumber.factorization(number)));

    if (primeNumber.formula.size() >= 2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(number);
      stringBuilder.append('=');
      stringBuilder.append(primeNumber.formula.get(0));

      for (int i = 1; i < primeNumber.formula.size(); i++) {
        stringBuilder.append('*');
        stringBuilder.append(primeNumber.formula.get(i));
      }

      System.out.println(stringBuilder.toString());

    }
  }
}
