package problem;

public class NumberBaseConversion {
  /**
   *
   * @param origin 原始数字组成的字符串
   * @param base 最多 16
   * @return
   */
  public long toDecimal(String origin, int base) {
    if (base > 16) throw new RuntimeException("maximum base is 16!");
    if (origin.isEmpty()) return 0;
    // 注意负数
    boolean isNegative = origin.charAt(0) == '-';
    if (origin.length() == 1 && isNegative) return 0;

    // 十六进制有 A~F
    Character[] chars = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    long sum = 0;
    int max = origin.length() - 1;
    for (int i = isNegative ? 1 : 0; i <= max; i++) {
      char ch = origin.charAt(i);

      for (int j = 0; j < chars.length; j++) {
        if (chars[j].equals(Character.toUpperCase(ch))) {
          // 按权展开求和，数组低位是数字的高位
          sum += j * Math.pow(base, max - i);
          break;
        }
      }
    }
    return isNegative ? -sum : sum;
  }

  public static void main(String[] args) {
    NumberBaseConversion conversion = new NumberBaseConversion();
    System.out.println(conversion.toDecimal("101101", 2));
    System.out.println(conversion.toDecimal("-", 2));
    System.out.println(conversion.toDecimal("-1", 2));
    System.out.println(conversion.toDecimal("FF20", 16));
  }
}
