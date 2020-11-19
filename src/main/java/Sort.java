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
    if (array.length < 2) return array;

    int[] result = Arrays.copyOf(array, array.length);
    int i = 0, j;
    boolean hasSwitch;

    int count = 0;

    for(; i < result.length - 1; i++){
      hasSwitch = false;

      for(j = 0; j < result.length - 1 - i; j++){
        count++;

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

    System.out.println("bubble invoked times: " + count);

    return result;
  }

  /**
   * 空间复杂度 O(1), 是原地排序算法
   * 是稳定的
   * 平均情况下的时间复杂度就是 O(n2)
   * 实现的时候，最好一开始就想清楚，到底是从小到大，还是从大到小
   * @param array 要排序的数组，原始数据不会被改变
   * @param type 升序还是降序
   * @return 返回排序后的数组
   */
  static int[] insertion(int[] array, SORT_TYPE type) {
    if (array.length < 2) return array;
    int[] result = Arrays.copyOf(array, array.length);

    int count = 0;

    // 未排序区间，从第 2 个元素算起
    for(int i = 1; i < result.length; i++) {
      int value = result[i];
      // 已排序区间，从第 1 个元素算起, 也即首个未排序元素的前一个元素
      int j = i - 1;

      // 依次向前比较
      for(; j >=0 ; j--) {
        count++;

        if(
          type == SORT_TYPE.ASC && value < result[j] ||
            type == SORT_TYPE.DESC && value > result[j]
        ) {
          result[j + 1] = result[j];
        }
        else break;
      }
      // 因为循环会--，故要 +1 才能回到为 result[j] 赋值
      result[j + 1] = value;
    }

    System.out.println("insertion invoked times: " + count);

    return result;
  }

  /**
   *
   * @param array 要排序的数组，原始数据不会被改变
   * @param type 升序还是降序
   * @return 返回排序后的数组
   */
  static int[] selection(int[] array, SORT_TYPE type) {
    if (array.length < 2) return array;
    int[] result = Arrays.copyOf(array, array.length);

    int count = 0;

    for(int i = 0; i < result.length - 1; i++) {
      int position = i;

      for(int j = i + 1; j < result.length; j++) {
        count++;

        if(
          type == SORT_TYPE.ASC && result[j] < result[position] ||
            type == SORT_TYPE.DESC && result[j] > result[position]
        ) {
          // 对于数组来说，找到对应最小值对应的下标，即相当于找到了最小值
          position = j;
        }
      }

      int temp = result[i];
      result[i] = result[position];
      result[position] = temp;
    }

    System.out.println("selection invoked times: " + count);

    return result;
  }

  static void quick(int[] array, int left, int right, SORT_TYPE type) {
    if (array.length < 2) return;
    if (left >= right) return ;

//    int[] result = Arrays.copyOf(array, array.length);

//    int count = 0;
    int pivot = division(array, left, right);
    quick(array, left, pivot - 1, type);
    quick(array, pivot + 1, right, type);


//    System.out.println("quick invoked times: " + count);

//    return result;
  }

  private static int division(int[] array, int left, int right) {
    int base = array[left];

    // 从小到到在排序，则先从右向左扫描找小的，再从左向右扫描找大的
    while (left < right && array[right] > base)
      right--;
    array[left] = array[right];

    while (left < right && array[left] < base)
      left++;
    array[right] = array[left];

    array[left] = base;

    return left;
  }

}
