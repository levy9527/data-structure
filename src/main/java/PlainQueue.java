import java.util.Arrays;

/**
 * 顺序队列，使用移动数组来解决“假溢出”问题，有一定开销
 * @param <T>
 */
public class PlainQueue<T> implements Queue<T>{
  private T[] array;
  private int capacity;
  private int head = 0;
  private int tail = 0;

  PlainQueue(int capacity) {
    if (capacity <=0) throw new RuntimeException("capacity must > 0");

    array = (T[])new Object[capacity];
    this.capacity = capacity;
  }

  @Override
  public boolean enqueue(T element) {
    if(tail >= capacity) return false;

    array[tail] = element;
    tail++;
    return true;
  }

  @Override
  public T dequeue() {
    if(head == tail) return null;
    T result = array[0];

    for(int i = 0; i < tail - 1; i++) {
      array[i] = array[i + 1];
    }
    array[tail - 1] = null;
    tail--;

    return result;
  }

  @Override
  public T head() {
    return array[0];
  }

  @Override
  public int size() {
    return tail;
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(array, tail));
  }
}
