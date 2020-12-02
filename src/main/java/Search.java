import java.util.function.Function;

public class Search {

  /**
   *
   * @param data input array
   * @param isFound if isFound return true, stop searching; otherwise continue
   * @return found element
   */
  public static<T> T sequential(T[] data, Function<T, Boolean> isFound) {
    T result = null;
    for (int i = 0; i < data.length; i++) {
      if (isFound.apply(data[i])) {
        result = data[i];
        break;
      };
    }

    return result;
  }

  /**
   * @param data input array
//   * @param getKey return data.key as the primary key to search
   * @return found element's index
   */
  public static int binary(int[] data, int key) {
    int result = -1;
    int low = 0,
      high = data.length - 1,
      mid = (low + high) / 2;



    while (low <= high) {
      if (data[mid] == key) return mid;
      if (data[mid] > key) {
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
      mid = (low + high) / 2;
    }

    return result;
  }
}
