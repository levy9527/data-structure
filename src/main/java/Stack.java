public interface Stack<T> {
  boolean push(T element);

  T pop();

  int size();

  T[] toArray();
}
