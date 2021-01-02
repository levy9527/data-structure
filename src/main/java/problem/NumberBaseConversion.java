package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberBaseConversion {
  /**
   *
   * @param numberStr 原始数字组成的字符串
   * @param base 最多 16
   * @return
   */
  public long toDecimal(String numberStr, int base) {
    if (base > 16) throw new RuntimeException("maximum base is 16!");
    if (numberStr.isEmpty()) return 0;
    // 注意负数
    boolean isNegative = numberStr.charAt(0) == '-';
    if (numberStr.length() == 1 && isNegative) return 0;

    // 十六进制有 A~F
    Character[] chars = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    long sum = 0;
    int max = numberStr.length() - 1;
    for (int i = isNegative ? 1 : 0; i <= max; i++) {
      char ch = numberStr.charAt(i);

      for (int j = 0; j < chars.length; j++) {
        // 关键是用数组的元素匹配来获得 10 进制的数字，避免了冗余的 if-else
        if (chars[j].equals(Character.toUpperCase(ch))) {
          // 按权展开求和，数组低位是数字的高位
          sum += j * Math.pow(base, max - i);
          break;
        }
      }
    }
    return isNegative ? -sum : sum;
  }

  public String toOther(long decimal, int base) {
    if (base > 16) throw new RuntimeException("maximum base is 16!");
    if (decimal == 0) return "0";
    boolean isNegative = false;
    if (decimal < 0) {
      isNegative = true;
      decimal = -decimal;
    }

    Deque<String> deque = new ArrayDeque<>();
    String[] strs = {
      "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
    };

    // 一直除到商为 0 为止
    long quotient = decimal;
    while (quotient != 0) {
      // TODO 处理十六进制，要用字符串
      deque.addFirst(strs[(int) (quotient % base)]);
      quotient /= base;
    }

    StringBuilder builder = new StringBuilder();

    deque.forEach(builder::append);

    return isNegative ? "-" + builder.toString(): builder.toString();
  }

  public static void main(String[] args) {
    NumberBaseConversion conversion = new NumberBaseConversion();
    System.out.println("--- toDecimal ---");
    System.out.println(conversion.toDecimal("101101", 2));
    System.out.println(conversion.toDecimal("-", 2));
    System.out.println(conversion.toDecimal("-1", 2));
    System.out.println(conversion.toDecimal("FF20", 16));

    System.out.println("--- toOther ---");
    System.out.println(conversion.toOther(45, 2));
    System.out.println(conversion.toOther(-0, 2));
    System.out.println(conversion.toOther(-1, 2));
    System.out.println(conversion.toOther(65312, 16));
  }
}
