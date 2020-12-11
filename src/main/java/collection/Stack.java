package collection;

public interface Stack<T> {
  boolean push(T element);

  T pop();

  T peek();

  int size();

  T[] toArray();
}
