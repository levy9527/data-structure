package effective;

import java.util.HashSet;
import java.util.Set;

/**
 * Item40: Consistently use the Override annotation
 */
public class Bigram {
  private final char first;
  private final char second;
  public Bigram(char first, char second) {
    this.first  = first;
    this.second = second;
  }
  /**
   * Do it wrong. Without @override annotation, it's hard to find that it's overloading not overriding
   * So this method actually will never be invoked
   * At this point, it means class Bigram only rewrites hashCode but not equals
   * So this causes the problem shown in the main method
   */
  public boolean equals(Bigram b) {
    return b.first == first && b.second == second;
  }
  public int hashCode() {
    return 31 * first + second;
  }
  public static void main(String[] args) {
    Set<Bigram> s = new HashSet<>();
    for (int i = 0; i < 10; i++)
      for (char ch = 'a'; ch <= 'z'; ch++)
        s.add(new Bigram(ch, ch)); // for same hashCode, it will compare object reference
    System.out.println(s.size());
  }
}
