import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SearchTest {
  private Integer[] array;
  @BeforeEach
  void init() {
    array = new Integer[]{6, 12, 28, 37, 54, 65, 69, 83, 90, 92};
  }

  @Test
  void sequentialSearch() {
    // https://bugs.openjdk.java.net/browse/JDK-8129589
    Integer result;

    result = Search.sequential(array, data -> data == 12);
    assertEquals(12, result);

    result = Search.sequential(array, data -> data == 66);
    assertNull(result);
  }

  @Test
  void binarySearch() {
    int[] array1 = new int[]{6, 12, 28, 37, 54, 65, 69, 83, 90, 92};
    int index = 0;

    assertEquals(3, Search.binary(array1, 37));
    assertEquals(-1, Search.binary(array1, 66));
  }
}
