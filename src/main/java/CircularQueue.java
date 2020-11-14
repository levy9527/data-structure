import java.util.Arrays;
import java.util.Objects;

/**
 * 循环队列，解决“假溢出”问题不需要移动数组，效率高
 * @param <T>
 */
public class CircularQueue<T> implements Queue<T>{
  private T[] array;
  private int capacity;
  private int head = 0;
  private int tail = 0;

  CircularQueue(int capacity) {
    if(capacity <=0) throw new RuntimeException("capacity must > 0");

    array = (T[])new Object[capacity];
    this.capacity = capacity;
  }

  @Override
  public boolean enqueue(T element) {
    if(head == tail) {
      if(!Objects.isNull(array[head])) return false;
    }

    // 取余数
    array[tail] = element;
    tail = ++tail % capacity;

    return true;
  }

  @Override
  public T dequeue() {
    if(head == tail && Objects.isNull(array[head])) return null;

    T result = array[head];
    array[head] = null;
    head = ++head % capacity;

    return result;
  }

  @Override
  public T head() {
    return array[head];
  }

  @Override
  public int size() {
    if(tail > head) return tail - head;
    else if (tail < head) return tail + capacity - head;
    else if (Objects.isNull(array[head])) return 0;
    return capacity;
  }

  @Override
  public String toString() {
    int size = this.size();
    T[] clone = (T[])new Object[size];

    for (int i = 0; i < size; i++) {
      clone[i] = array[(head + i) % capacity];
    }

    return Arrays.toString(clone);
  }
}
