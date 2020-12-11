package collection;

public interface List<T> {
  boolean add(T element);

  boolean insert(int index, T element);

  T remove(int index);

  boolean set(int index, T element);

  T get(int index);

  int size();

  boolean contains(T element);

  T[] toArray();

}
