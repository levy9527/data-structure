package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AutomorphicNumber {
  /**
   * 自守数：平方后得到的数后几位与本身一致
   */
  boolean isAutomorphic(int number) {
    if (number < 1) return false;

    // when Math.pow(number, 2) larger than 2147483647(2^31 -1), it will not work
//    int power = (int) Math.pow(number, 2);
    int power = this.pow(number);
    int sum = 0, i = 0, remain = number;
    while (remain > 0) {
      sum += (power % 10) * Math.pow(10, i);
      remain /= 10;
      power /= 10;
      i++;
    }

    return sum == number;
  }

  /**
   * 625 * 625 in this case can be considering as sum of:
   * - 5 * 600
   * - 25 * 20
   * - 625 * 5
   */
  private int pow(int number) {
    int sum = 0;
    int remain = number;
    List<Integer> list = new ArrayList<>();

    while (remain > 0) {
      list.add(remain % 10);
      remain /= 10;
    }

    int max = list.size() - 1;
    int base = 0;
    for (int i = 0; i <= max; i++) {
      base += list.get(i) * Math.pow(10, i);
      sum += base * list.get(max - i) * Math.pow(10, max - i);
    }

    return sum;
  }

  public static void main(String[] args) {
    AutomorphicNumber automorphicNumber = new AutomorphicNumber();
    List<Integer> result = new LinkedList<>();
    int range = 200000;

    for (int i = 1; i <= range; i++) {
      if (automorphicNumber.isAutomorphic(i)) result.add(i);
    }

    System.out.println(Arrays.toString(result.toArray()));
  }
}
