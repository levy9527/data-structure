public interface Queue<T> {
  boolean enqueue(T element);

  T dequeue();

  T head();

  int size();
}
