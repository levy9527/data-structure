package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArmstrongNumber {
  /**
   * 阿姆斯特朗数：n位数的每一位的n次方之和等于n本身
   */
  boolean isArmstrongNumber(int number) {
    int remain = number;
    int power = 0;
    int sum = 0;
    List<Integer> list = new ArrayList<>(10);

    while (remain > 0) {
      list.add(remain % 10);
      power ++;
      remain = remain / 10;
    }

    for (int n : list) {
      sum += Math.pow(n, power);
    }

    return number == sum;
  }


  public static void main(String[] args) {
    ArmstrongNumber amicableNumber = new ArmstrongNumber();
    List<Integer> result = new LinkedList<>();
    int range = 10000;

    for (int i = 1; i <= range; i++) {
      if (amicableNumber.isArmstrongNumber(i)) result.add(i);
    }

    System.out.println(Arrays.toString(result.toArray()));
  }
}
