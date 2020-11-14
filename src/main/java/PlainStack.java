/**
 * 普通数组来实现的栈，其实 top 指标就相当于 size
 * @param <T>
 */
public class PlainStack<T> implements Stack<T>{
  private int capacity;
  private int top = 0;
  private T[] array;

  PlainStack(int capacity) {
    if (capacity <=0) throw new RuntimeException("capacity must > 0");

    this.capacity = capacity;
    array = (T[])new Object[capacity];
  }

  @Override
  public boolean push(T element) {
    if (top >= capacity) return false;

    array[top] = element;
    top++;
    return true;
  }

  @Override
  public T pop() {
    if (top < 1) return null;

    T result = array[top - 1];
    array[top - 1] = null;
    top--;
    return result;
  }

  @Override
  public T peek() {
    if (top < 1) return null;

    return array[top - 1];
  }

  @Override
  public int size() {
    return this.top;
  }

  @Override
  public T[] toArray() {
    T[] result = (T[])new Object[top];

    for(int i = 0; i < top; i++) {
      result[i] = array[top - 1 - i];
    }

    return result;
  }
}
