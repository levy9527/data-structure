package problem;

public class Step {
  int howMuch() {
    int step = 7;
    while (true) {
      if (step % 2 == 1 &&
        step % 3 == 2 &&
        step % 5 == 4 &&
        step % 6 == 5
      ) break;
      else step += 7;
    }
    return step;
  }

  public static void main(String[] args) {
    Step step = new Step();
    System.out.println(step.howMuch());
  }
}
