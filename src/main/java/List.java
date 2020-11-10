public interface List<T> {
  boolean add(T element);

  boolean insert(int index, T element);

  boolean remove(int index);

  boolean set(int index, T element);

  T get(int index);

  int size();

  boolean contains(T element);

  public T[] toArray();

}
