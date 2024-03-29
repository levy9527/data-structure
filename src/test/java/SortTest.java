import collection.Sort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
  private int[] arrayReversed;
  private int[] arrayOrdered;
  private int[] arrayRandom;
  private int[] expected;
  @BeforeEach
  void init() {
    arrayReversed = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    arrayOrdered = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    arrayRandom = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  }

  @Test
  void bubbleSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.bubble(arrayReversed, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.bubble(arrayOrdered, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.bubble(arrayRandom, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.bubble(arrayRandom, Sort.SORT_TYPE.DESC)));
  }

  @Test
  void insertionSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.insertion(arrayReversed, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.insertion(arrayOrdered, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.insertion(arrayRandom, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.insertion(arrayRandom, Sort.SORT_TYPE.DESC)));
  }

  @Test
  void selectionSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.selection(arrayReversed, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.selection(arrayOrdered, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.selection(arrayRandom, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(Sort.selection(arrayRandom, Sort.SORT_TYPE.DESC)));
  }

  @Test
  void quickSort() {
    Sort.quick(arrayReversed, 0,arrayReversed.length - 1, Sort.SORT_TYPE.ASC);
    assertEquals(Arrays.toString(expected), Arrays.toString(arrayReversed));
//    assertEquals(Arrays.toString(expected), Arrays.toString(collection.Sort.quick(arrayReversed, collection.SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(expected), Arrays.toString(collection.Sort.quick(arrayOrdered, collection.SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(expected), Arrays.toString(collection.Sort.quick(arrayRandom, collection.SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(collection.Sort.quick(arrayRandom, collection.SORT_TYPE.DESC)));
  }

  @Test
  void shellSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.shell(arrayReversed, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.shell(arrayOrdered, Sort.SORT_TYPE.ASC)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.shell(arrayRandom, Sort.SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(collection.Sort.quick(arrayRandom, collection.SORT_TYPE.DESC)));

  }

  @Test
  void mergeSort() {
//    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.merge(arrayReversed, Sort.SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.merge(arrayOrdered, Sort.SORT_TYPE.ASC)));
//    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.merge(arrayRandom, Sort.SORT_TYPE.ASC)));
    Sort.mergeSort(arrayReversed, 0, arrayReversed.length - 1);
    assertArrayEquals(expected, arrayReversed);

    int[] arr = new int[]{4,1,3,9,7};
    Sort.mergeSort(arr, 0, arr.length - 1);
    assertArrayEquals(new int[]{1, 3, 4, 7, 9}, arr);

//    assertEquals(Arrays.toString(arrayReversed), Arrays.toString(collection.Sort.quick(arrayRandom, collection.SORT_TYPE.DESC)));

  }

  @Test
  void heapSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.heap(arrayReversed)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.heap(arrayOrdered)));
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.heap(arrayRandom)));
  }

  @Test
  public void countingSort() {
    assertEquals(Arrays.toString(expected), Arrays.toString(Sort.counting(arrayRandom, Sort.SORT_TYPE.ASC)));
  }
}
