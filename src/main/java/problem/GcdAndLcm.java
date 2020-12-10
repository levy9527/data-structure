package problem;

public class GcdAndLcm {
  /**
   * greatest common divisor
   * euclid algorithm: it would have performance problem if m or n is big number (larger than 2^63 - 1)
   */
  int gcd(int m, int n) {
    if (m < n) {
      int t = n;
      n = m;
      m = t;
    }

    int remain;
    do {
      remain = m % n;
      m = n;
      n = remain;
    }while (remain != 0);

    return m;
  }

  int gcdByStein(int a, int b) {
    if (a == 0) return b;
    if (b == 0) return a;

    if (isEven(a) && isEven(b)) {
      return 2 * gcdByStein(a >> 1,b >> 1);
    }
    else if (isEven(a)) {
      return gcdByStein(a >> 1, b);
    }
    else if (isEven(b)) {
      return gcdByStein(a, b >> 1);
    }

    return gcdByStein(Math.abs(a - b), Math.min(a, b));

  }

  private boolean isEven(int n) {
    return n % 2 == 0;
  }

  /**
   * least common multiple
   */
  int lcm(int m, int n) {
    return m * n / gcd(m, n);
  }


  public static void main(String[] args) {
    GcdAndLcm gcdAndLcm = new GcdAndLcm();
    int m = 12, n = 56;

    System.out.println(gcdAndLcm.lcm(m, n));
    System.out.println(gcdAndLcm.gcd(m, n));
    System.out.println(gcdAndLcm.gcd(5, 3));


    System.out.println("--- gcdByStein ---");
    System.out.println(gcdAndLcm.gcdByStein(m, n));
    System.out.println(gcdAndLcm.gcdByStein(5, 3));
  }
}
