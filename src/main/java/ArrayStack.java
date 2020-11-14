public class ArrayStack<T> implements Stack<T>{
  private List<T> list;

  ArrayStack(int capacity) {
    list = new ArrayList<>(capacity);
  }

  @Override
  public boolean push(T element) {
    return list.add(element);
  }

  @Override
  public T pop() {
    return list.remove(list.size() - 1);
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public T[] toArray() {
    int size = list.size();
    List<T> result = new ArrayList<>(size);

    for(int i = 0; i < size; i++) {
      result.add(list.get(size - 1 - i));
    }

    return result.toArray();
  }
}
