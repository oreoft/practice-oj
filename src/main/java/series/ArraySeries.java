package series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 数组的题目
 *
 * @author zyf
 * @date 2021-11-16 19:11
 */
public class ArraySeries {


  /**
   * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
   * https://leetcode-cn.com/problems/permutations/
   * @param nums 数组
   * @return 返回全排列
   */
  // TODO-Z-2021/11/16: 这个最好用回溯去做, 下次研究下
  public static List<List<Integer>> permute(int[] nums) {
    // 拆箱把nums变成list, 然后new一个set去重容器
    List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    Set<List<Integer>> set = new HashSet<>();

    // 拿到阶乘的全排列总数
    int sum = 1;
    for (int i = 1; i <= list.size(); i++) {
      sum = sum * i;
    }

    // 只要set里面的数量不等于最终全排列的总数,就死循环shuffle
    while (set.size() < sum) {
      LinkedList<Integer> temp = new LinkedList<>(list);
      Collections.shuffle(temp);
      set.add(temp);
    }

    // 最后开开心心输出
    return new ArrayList<>(set);
  }

  /**
   * 合并两个有序数组为一个新的有序数组
   * [1, 2, 3] [5, 6, 7] -> [1, 2, 3, 5, 6, 7]
   * @param a a数组
   * @param b b数组
   * @return 返回一个新数组
   */
  public static int[] mergeTwoSortedArraysTest(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int aSize = 0, bSize = 0, cSize = 0;
    while (aSize < a.length && bSize < b.length) {
      if (a[aSize] < b[bSize]) {
        c[cSize++] = a[aSize++];
      } else {
        c[cSize++] = b[bSize++];
      }
    }
    while (aSize < a.length) {
      c[cSize++] = a[aSize++];
    }
    while (bSize < b.length) {
      c[cSize++] = b[bSize++];
    }
    return c;
  }


}
