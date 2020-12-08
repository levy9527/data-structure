package problem;

import java.util.HashMap;
import java.util.Map;

public class AmicableNumber {
  int calcFactorSum(int number) {
    assert number > 1;

    int result = 1;
    int max = number;

    for(int i = 2; i <= max; i++) {
      if (number % i == 0) {
        result += i;
        if (max == number) max = number / i;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    AmicableNumber amicableNumber = new AmicableNumber();
    Map<String, String> result = new HashMap<>();
    int range = 10000;

    for (int i = 2; i <= range; i++) {
      int sum = amicableNumber.calcFactorSum(i);
      if (i < sum && i == amicableNumber.calcFactorSum(sum)) {
        StringBuilder builder = new StringBuilder();
        builder.append(i);
        builder.append("-");
        builder.append(sum);

        result.put(builder.toString(), builder.toString());
      }
    }

    // 220-284
    //1184-1210
    //2620-2924
    //5020-5564
    //6232-6368
    for (String numbers: result.values())
      System.out.println(numbers);
  }
}
