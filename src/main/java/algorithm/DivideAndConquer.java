package algorithm;

import java.util.Arrays;

public class DivideAndConquer {
  private int[][] a = new int[64 + 1][64 + 1];
  void gamecal(int k, int n) {
    if (n == 2) {
      a[k][1] = k;
      a[k][2] = k + 1;
      a[k+1][1] = k + 1;
      a[k+1][2] = k;
    }
    else {
      gamecal(k, n/2);
      gamecal(k + n/2, n/2);

      int i, j;
      // 把左下角赋值给右上角
      for (i = k; i < k + n/2; i++)
        for (j = 1 + n/2; j <= n; j++) {
          a[i][j] = a[i + n/2][j - n/2];
        }

      // 把左上角赋值给右下角
      for (i = k + n/2; i < k + n; i++)
        for (j = 1 + n/2; j <= n; j++) {
          a[i][j] = a[i - n/2][j - n/2];
        }

    }

//    System.out.println(Arrays.deepToString(a));
  }
  private void schedule(int[] sequence, int[][] result) {
    if (sequence.length == 2) {
      result[sequence[0]][0] = sequence[1];
      result[sequence[1]][1] = sequence[0];
    }
  }

  public int[][] competition(int players) {
    if (players % 2 != 0) throw new RuntimeException("players number should be even");
    if (players <= 0 || players > 64) throw new RuntimeException("0 < players <= 64");

    int[][] result = new int[players][players];

    int[] sequence = new int[players];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = i;
    }

    schedule(sequence, result);

    return result;
  }

  public static void main(String[] args) {
    DivideAndConquer divideAndConquer = new DivideAndConquer();
    int n = 8;
    divideAndConquer.gamecal(1, n);

    int[][] a = divideAndConquer.a;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print( a[i][j] + " ");
      }
      System.out.println();
    }
//    System.out.println(Arrays.deepToString(divideAndConquer.competition(2)));
//    System.out.println(divideAndConquer.competition(4));
//    System.out.println(divideAndConquer.competition(8));
//    System.out.println(divideAndConquer.competition(16));
  }
}
