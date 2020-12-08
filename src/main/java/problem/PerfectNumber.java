package problem;

import java.util.Arrays;
import java.util.LinkedList;

public class PerfectNumber {
  boolean isPerfectNumber(int n) {
    int max = n - 1;
    LinkedList<Integer> factors = new LinkedList<>();

    for (int i = 2; i <= max; i++) {
      if (n % i == 0) {
        factors.add(i);
        if (max == n - 1) max = n / i;
      }
    }

    int sum = 0;
    for (int factor: factors) {
      sum += factor;
    }

    return sum + 1 == n;
  }

  public static void main(String[] args) {
    int range = 10000;
    PerfectNumber perfectNumber = new PerfectNumber();

    LinkedList<Integer> list = new LinkedList<>();

    for (int i = 2; i <= range; i++) {
      if (perfectNumber.isPerfectNumber(i))
        list.add(i);
    }

    System.out.println(Arrays.toString(list.toArray()));
  }
}
