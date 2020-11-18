import java.util.Arrays;

enum SORT_TYPE {
  ASC,
  DESC
}

public class Sort {
  static int[] bubble(int[] array, SORT_TYPE type) {
    System.out.println("bubble start: " + System.currentTimeMillis());

    int[] result = Arrays.copyOf(array, array.length);
    boolean hasSwitch = false;

    for(int i = 0; i < result.length - 1; i++){
      for(int j = 0; j < result.length - 1 - i; j++){
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

    System.out.println("bubble end: " + System.currentTimeMillis());

    return result;
  }
}
