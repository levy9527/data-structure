package collection;

import java.util.Arrays;
import java.util.Objects;

/**
 * 还是存在一些问题，有些方法返回的是引用，而不是对象的拷贝
 * @param <T>
 */
public class ArrayList<T> implements List<T>{
  private int capacity;
  private int size = 0;
  private T[] array;

  public ArrayList(int capacity) {
    this.capacity = capacity;
    this.array = (T[]) new Object[capacity];
  }

  /**
   * add element in tail
   */
  @Override
  public boolean add(T element) {
    if (size == capacity) return false;

    this.array[this.size] = element;
    this.size++;
    return true;
  }

  @Override
  public boolean insert(int index, T element) {
    if (size == capacity) return false;

    for (int i = capacity - 1; i > index; i--) {
      this.array[i] = this.array[i - 1];
    }
    this.array[index] = element;
    size++;

    return true;
  }

  @Override
  public T remove(int index) {
    if (index < 0 || index >= this.size) return null;

    T result = this.array[index];

    for(int i = index; i < this.size - 1; i++) {
      this.array[i] = this.array[i+1];
    }

    this.array[size - 1] = null;
    this.size--;

    return result;
  }

  /**
   * insert element in middle
   * @param index
   * @param element
   * @return
   */
  @Override
  public boolean set(int index, T element) {
    if (index < 0 || index >= this.capacity) return false;

    if (Objects.isNull(this.array[index])) this.size++;

    this.array[index] = element;
    return true;
  }

  @Override
  public T get(int index) {
    T result;
    if (index < 0 || index >= this.size) return null;
    result = this.array[index];
    return result;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean contains(T element) {
    boolean result = false;
    for (T t: this.array) {
      if(t.equals(element)) {
        result = true;
        break;
      }
    }

    return result;
  }

  @Override
  public T[] toArray() {
    return Arrays.copyOf(this.array, this.size());
  }
}
