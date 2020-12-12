package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicNumber {
  /**
   * 只能判断自然数，即 n >= 0
   */
  boolean isPalindrome(int n) {
    if (n < 10) return false;
    // 由低到高，取出后重新排列，如果与原数字相等，则是回文数
    int remain = n;
    List<Integer> list = new ArrayList<>();

    while (remain != 0) {
      list.add(remain % 10);
      remain /=  10;
    }

    int sum = 0;
    int max = list.size() - 1;
    for (int i = 0; i <= max; i++) {
      sum += list.get(i) * Math.pow(10, max - i);
    }

    return sum == n;
  }


  public static void main(String[] args) {
    PalindromicNumber palindromicNumber = new PalindromicNumber();
    PrimeNumber primeNumber = new PrimeNumber();
    int range = 1000;

    List<Integer> primes = primeNumber.eratosthenes(range);
    primes.removeIf(number -> !palindromicNumber.isPalindrome(number));

    System.out.println(Arrays.toString(primes.toArray()));
  }

}
