import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
  private int[] arrayReversed = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
  private int[] arrayOrdered = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  private int[] arrayRandom = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
  private int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//  @BeforeEach
//  void init() {
//  }

  @Test
  void bubbleSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.bubble(arrayReversed, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.bubble(arrayOrdered, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.bubble(arrayRandom, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.bubble(arrayRandom, SORT_TYPE.DESC)));
  }

  @Test
  void insertionSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.insertion(arrayReversed, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.insertion(arrayOrdered, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.insertion(arrayRandom, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.insertion(arrayRandom, SORT_TYPE.DESC)));
  }

  @Test
  void selectionSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.selection(arrayReversed, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.selection(arrayOrdered, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.selection(arrayRandom, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.selection(arrayRandom, SORT_TYPE.DESC)));
  }

  @Test
  void quickSort() {
    Sort.quick(arrayReversed, 0,arrayReversed.length - 1, SORT_TYPE.ASC);
    assertEquals(Arrays.toString(expected), Arrays.toString(arrayReversed));
//    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.quick(arrayReversed, SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.quick(arrayOrdered, SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.quick(arrayRandom, SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.quick(arrayRandom, SORT_TYPE.DESC)));
  }

  @Test
  void shellSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.shell(arrayReversed, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.shell(arrayOrdered, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.shell(arrayRandom, SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.quick(arrayRandom, SORT_TYPE.DESC)));

  }

  @Test
  void mergeSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.merge(arrayReversed, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.merge(arrayOrdered, SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.merge(arrayRandom, SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.quick(arrayRandom, SORT_TYPE.DESC)));

  }

  @Test
  void heapSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.heap(arrayReversed)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.heap(arrayOrdered)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.heap(arrayRandom)));
  }
}
