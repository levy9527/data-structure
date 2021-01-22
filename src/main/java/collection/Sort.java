package collection;

import java.util.Arrays;


public class Sort {
  public enum SORT_TYPE {
    ASC,
    DESC
  }
  /**
   * 空间复杂度 O(1), 是原地排序算法
   * 是稳定的
   * 平均情况下的时间复杂度就是 O(n2)
   * @param array 要排序的数组，原始数据不会被改变
   * @param type 升序还是降序
   * @return 返回排序后的数组
   */
  public static int[] bubble(int[] array, SORT_TYPE type) {
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
  public static int[] insertion(int[] array, SORT_TYPE type) {
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
  public static int[] selection(int[] array, SORT_TYPE type) {
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
   */
  public static void quick(int[] array, int left, int right, SORT_TYPE type) {
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
   * @return 返回排序后的数组
   */
  public static int[] shell(int[] array, SORT_TYPE type) {
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
   * @deprecated 这是化零为整的思路，比较复杂
   * @return 返回排序后的数组
   */
  public static int[] merge(int[] array, SORT_TYPE type) {
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
      result = Arrays.copyOf(temp, temp.length);
    }

    return result;
  }

  /**
   * 分治、化整为零的归并排序写法
   * T: O(nlogn) S: O(n)
   */
  public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    // 假设 0 - 0, 则得到 0，显然应该 + 1 才合理
    int[] temp = new int[right - left + 1];
    int i = 0, j = left, k = mid + 1;

    while (j <= mid && k <= right) {
      if (arr[j] <= arr[k])
        temp[i++] = arr[j++];
      else
        temp[i++] = arr[k++];
    }

    while (j <= mid) temp[i++] = arr[j++];
    while (k <= right) temp[i++] = arr[k++];

    for (i = 0; i < temp.length; i++)
      arr[left + i] = temp[i];
  }

  /**
   * 不稳定，因为顶部元素会与尾部元素交换
   * 构造大顶堆进行排序
   * @return 返回排序后的数组
   */
  public static int[] heap(int[] array) {
    if (array.length < 2) return array;
    int[] result = Arrays.copyOf(array, array.length);
    int max = result.length - 1;

    // 先对非叶子节点动手，构造堆，也即完全二叉树
    for (int i = (max - 1) / 2; i >= 0; i--)
      headAdjust(result, i, max);

    // 再逐步输出堆顶元素
    for (int i = max; i > 0; i--) {
      // 把顶部元素与尾部元素相交换（因为此时构造的是大顶堆，所以最大的数放数组最后面）
      int temp = result[i];
      result[i] = result[0];
      result[0] = temp;

      headAdjust(result, 0, i - 1);
    }

    return result;
  }

  /**
   *
   * @param array 待排序数组
   * @param node 要调整为符合堆要求的节点
   * @param max 待排序元素的最大下标，这个参数很重要，不能直接使用 array.length，堆排序是原地排序，数组长度不变，而待排序的数据却一直在减少
   */
  private static void headAdjust(int[] array, int node, int max) {
    if (node < 0) return;

    // 首先要判断节点是否是非叶子节点——完全二叉树，非叶子节点一定会有左子树
    while (node * 2 + 1 <= max) {
      int left = node * 2 + 1;

      // 判断是否有右子树，且数值更大
      if (left + 1 <= max && array[left + 1] > array[left]) left++;

      if (array[node] < array[left]) {
        int temp = array[node];
        array[node] = array[left];
        array[left] = temp;

        node = left;
      }
      else break;
    }
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

    // 从小到大排序，则先从右向左扫描找小的，再从左向右扫描找大的
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
