package series;

import org.junit.jupiter.api.Test;

/**
 * 动态规划问题
 *
 * @author zyf
 * @date 2021-11-16 21:11
 */
public class DPSeries {

  // 1,1,2,3,5,8....

  public static void main1(String[] args) {
    int[] arr = new int[]{7, 7, -3, 2, 1, 2, 7};
    int pre = 0;
    int max = arr[0];
    for (int num : arr) {
      pre = Math.max(pre + num, num);
      max = Math.max(pre, max);
    }
    System.out.println(max);

  }

  public static void main(String[] args) {
    int[] arr = new int[]{7, 7, -3, 2, 1, 2, 7};
    int[] target = new int[arr.length];

    target[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      target[i] = Math.max(arr[i] + target[i - 1], arr[i]);
    }

    int max = target[0];
    for (int i = 1; i < arr.length; i++) {
      if (target[i] > max) {
        max = target[i];
      }
    }

    System.out.println(max);

  }

  static int fib(int num) {
    int[] arr = new int[num + 1];
    arr[0] = 1;
    arr[1] = 1;
    for (int i = 2; i < arr.length; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[num];
  }

  @Test
  void Test() {
    int num = 3;
    int[] arr = new int[num + 1];
    arr[0] = 1;
    arr[1] = 1;
    for (int i = 2; i < arr.length; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    System.out.println(arr[num]);
  }


}
