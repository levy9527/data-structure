package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Greedy {
  // 精确到小数位两位
  // 计算单元是人民币分
  public Double[] makeChange(double payment) {
    if (payment <= 0) return null;

    // 把小数点后面的数字去掉
    long remain = (long) (payment * 100);
    long[] paperMoneys = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10};
    List<Double> result = new LinkedList<>();

    int i = 0;
    // 提高效率，减少重复查找
    for (; i < paperMoneys.length; i++)
      if (remain > paperMoneys[i]) break;;

    // 实际应用中，还要额外考虑找不清的情况，需要四舍五入
    while (remain > 0 && i < paperMoneys.length) {
      long money = paperMoneys[i];

      if (remain >= money) {
        // 找零
        remain -= money;
        result.add(((double)money / 100));
      }
      else if (remain >= 5 && remain < 10) {
        // 四舍五入
        remain = 0;
        result.add(10.0 / 100);
      }
      else i++;
    }

    return result.toArray(new Double[0]);
  }

  public static void main(String[] args) {
    Greedy greedy = new Greedy();
    System.out.println(Arrays.toString(greedy.makeChange(68.90)));
    System.out.println(Arrays.toString(greedy.makeChange(35.38)));
  }
}
