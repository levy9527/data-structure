package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    List<String> track = new ArrayList<>();
    if (s.length() < 4 || s.length() > 12) return result;

    backTrack(s.toCharArray(), 0, 1, track, result);
    return result;
  }




  private void backTrack(char[] chars, int begin, int end, List<String> track, List<String> result) {
    // 1. 0 <= x <= 255
    // 2. 用 . 分隔
    // 3. 不能用 0 填充，也即 0 之后一定接 .
    // 4. 所有字符都要用上
    // 剪枝：1.遍历完第一棵子树就结束；2.只遍历三层
    // 这是分隔点的试探: 1~3, 分隔三次,
    // start: 0, end: 1~3
//    for (int i = begin; i < s.length(); i++) {
//    }

    String s = "";
    String substring = s.substring(begin, end);
    int ip = Integer.parseInt(substring);
    if (ip == 0) {
      track.add(substring);
    }
    if (ip <= 255) track.add(substring);


    for (int i = 1; i <= 3; i++) {
//      backTrack(s, begin + track.size(), begin + track.size() + i,
//        track, result);
    }

    // 0~3, 3~6, 6~9, 9~12
    int ip1 = Integer.parseInt(s.substring(begin, end));
    if (ip1 == 0) {
      begin++;
      end++;
    }

    int ip2 = Integer.parseInt(s.substring(begin,end));
    if (ip2 == 0) {
      begin++;
      end++;
    }

    int ip3 = Integer.parseInt(s.substring(begin, end));
    if (ip3 == 0) {
      begin++;
      end++;
    }

    if (end + 3 < 12) {
      return;
    }
//    else {
//      String s4 = s.substring(end, end + 1);
//      if (s4.equals("0") ) {
//        if (end + 1 != s.length()) return;
//        else // 成立
//      }
//      else {
//        int ip4 = Integer.parseInt(s.substring(end, s.length()));
//        if (ip4 > 255) return;
//
//      }
//
//    }

  }
}
