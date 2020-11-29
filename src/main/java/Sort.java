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
   * 不稳定
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

  /**
   * 不稳定，因为存在交换
   * @pram type
   */
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

  /**
   * 不稳定，因为存在交换
   * @param array
   * @param type
   * @return
   */
  static int[] shell(int[] array, SORT_TYPE type) {
    if (array.length < 2) return null;
    int[] result = Arrays.copyOf(array, array.length);

    int s = result.length / 2;

    while (s >= 1) {
      // 拆分子序列
      // 这里不能使用前半段: 0 + s 去循环；因为 s 在变，则当 s = 1 时，会出现 i < 1 的判断，则无法遍历数组
      for (int i = s; i < result.length; i++) {
        int x = result[i];
        // 序列内根据增量 向前比较
        int j = i - s;

        while (j >= 0 && result[j] > x) {
          result[j + s] = result[j];
          j = j - s;
        }
        // 可以这样想：假设上面是 0 退出了循环，则 j < 0 了，故要把数字加回来
        result[j + s] = x;
      }
      s /= 2;
    }

    return result;
  }

  /**
   * 稳定，但需要占用与待排序数据等量的内存空间
   */
  static int[] merge(int array[], SORT_TYPE type) {
    int[] result = Arrays.copyOf(array, array.length);
    int[] temp = new int[array.length];
    // 初始子序列长度为1
    int len = 1;
    boolean flag = false;

    while (len < result.length) {
      if (!flag) {
        mergePass(result, temp, len);
      }
      else {
        mergePass(temp, result, len);
      }

      len *= 2;
      flag = !flag;
    }

    if (flag) {
      for (int i = 0; i < temp.length; i++)
        result[i] = temp[i];
    }

    return result;
  }

  private static void mergePass(int[] origin, int[] target, int len){
    int leftStart = 0;
    while (leftStart + len < origin.length) {
      int rightEnd = leftStart + 2 * len - 1;
      if (rightEnd >= origin.length) rightEnd = origin.length -1;

      mergeStep(origin, target, leftStart, leftStart + len - 1, rightEnd);

      leftStart = rightEnd + 1;
    }

    while (leftStart < origin.length) {
      target[leftStart] = origin[leftStart];
      leftStart++;
    }
  }

  private static void mergeStep(int[] origin, int[] target, int leftStart, int leftEnd, int rightEnd) {
    int rightStart = leftEnd + 1;
    int i = leftStart;

    while (leftStart <= leftEnd && rightStart <= rightEnd) {
      if (origin[leftStart] <= origin[rightStart]) {
        target[i++] = origin[leftStart++];
      }
      else {
        target[i++] = origin[rightStart++];
      }
    }

    while (leftStart <= leftEnd) target[i++] = origin[leftStart++];
    while (rightStart <= rightEnd) target[i++] = origin[rightStart++];
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
