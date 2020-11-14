public class LinkedStack<T> implements Stack<T>{
  private List<T> list;

  LinkedStack() {
    list = new LinkedList<>();
  }

  @Override
  public boolean push(T element) {
    return list.insert(0, element);
  }

  @Override
  public T pop() {
    return list.remove(0);
  }

  @Override
  public T peek() {
    return list.get(0);
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public T[] toArray() {
    return list.toArray();
  }
}
