package problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AutomorphicNumber {
  boolean isAutomorphic(int number) {
    if (number < 1) return false;

    // when Math.pow(number, 2) larger than 2147483647(2^31 -1), it will not work
    int power = (int) Math.pow(number, 2);
    int sum = 0, i = 0, data = number;
    while (data > 0) {
      sum += (power % 10) * Math.pow(10, i);
      data /= 10;
      power /= 10;
      i++;
    }

    return sum == number;
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
