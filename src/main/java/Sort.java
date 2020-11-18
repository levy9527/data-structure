import java.util.Arrays;

enum SORT_TYPE {
  ASC,
  DESC
}

public class Sort {
  /**
   * 空间复杂度 O(1), 是原地排序算法
   * 是稳定的
   * 平均情况下的时间复杂度就是 O(n2)
   * @param array 要排序的数组，原始数据不会被改变
   * @param type 升序还是降序
   * @return 返回排序后的数组
   */
  static int[] bubble(int[] array, SORT_TYPE type) {
    int[] result = Arrays.copyOf(array, array.length);
    int i = 0, j;
    boolean hasSwitch = false;

    for(; i < result.length - 1; i++){
      hasSwitch = false;

      for(j = 0; j < result.length - 1 - i; j++){
        if(
          type == SORT_TYPE.ASC && result[j] > result[j + 1] ||
            type == SORT_TYPE.DESC && result[j] < result[j + 1]
        ) {
          int temp = result[j];
          result[j] = result[j + 1];
          result[j+1] = temp;

          hasSwitch = true;
        }
      }
      if (!hasSwitch) break;
    }

    System.out.println("bubble invoked times: " + (!hasSwitch ? i + 1 : i));

    return result;
  }
}
