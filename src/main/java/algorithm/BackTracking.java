package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {
  private int len = 7;
  private int maxNum = 9;
  private int[] lottery = new int[len];
  private int[] numbers = new int[maxNum];

  public void lottery() {
    for (int i = 0; i < numbers.length; i++)
      numbers[i] = i + 1;

    this.generate(maxNum, len);
  }

  private void generate(int n, int m) {
    int i, j;

    for (i = n; i >= m; i--) {
      lottery[m - 1] = numbers[i - 1];
      if (m > 1)
        generate(i - 1, m - 1);
      else {
        System.out.println(Arrays.toString(lottery));
      }
    }
  }

  /**
   * 用1，2，3，4，5，6，7，8，9九个数组成3个3位数，其中两个3位数的和等于另一个3位数。
   * 要求必须要全部用到这9个数字，且不得重复
   */
  public List<List<Integer>> nineNumber() {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>(9);

    backTrackNineNumber(track, result);

    return result;
  }

  private void backTrackNineNumber(List<Integer> track, List<List<Integer>> result) {
    if (track.size() == 9) {
      // 固定根据数组下标取值
      int first = track.get(0) * 100 + track.get(1) * 10 + track.get(2);
      int second = track.get(3) * 100 + track.get(4) * 10 + track.get(5);
      int sum = track.get(6) * 100 + track.get(7) * 10 + track.get(8);
      if (first + second == sum) {
        List<Integer> record = new ArrayList<>(3);
        record.add(first);
        record.add(second);
        record.add(sum);
        result.add(record);
      }
      return;
    }

    for (int i = 0; i < 9; i++) {
      if (track.contains(i + 1)) continue;
      track.add(i + 1);
      backTrackNineNumber(track, result);
      track.remove(track.size() - 1);
    }
  }

  public static void main(String[] args) {
    BackTracking backTracking = new BackTracking();
    backTracking.lottery();

    System.out.println(backTracking.nineNumber());
  }
}
