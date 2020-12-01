import java.util.function.Function;

public class Search {

  public static<T> T sequential(T[] data, Function<T, Boolean> isFound) {
    T result = null;
    for (int i = 0; i < data.length; i++) {
      if (isFound.apply(data[i])) {
        result = data[i];
        break;
      };
    }

    return result;
  }
}
