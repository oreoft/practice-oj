package series;

/**
 * 排序类题
 *
 * @author zyf
 * @date 2021-11-16 08:11
 */
public class SortSeries {

  /**
   * 快速排序
   *
   * @param num 待排数组
   * @return 返回排好数组
   */
  public static int[] quickSort(int[] num) {
    quick(num, 0, num.length - 1);
    return num;
  }
  /**
   * 快速排序
   *
   * @param nums 要排序的数组
   * @param left 该轮排序最左元素
   * @param right 该轮排序最右元素
   */
  private static void quick(int[] nums, int left, int right) {
    // 如果左边大于或等于右边直接返回
    if (left >= right) {
      return;
    }
    // 把左右的指针保存下来, 并且把中心点确定成左边一号元素
    int l = left, r = right, p = nums[left];
    while (l < r) {
      // 看右边元素是否大于中心点, 如果大则右边++
      while (l < r && p < nums[r]) {
        r--;
      }
      // 跳到这里说明右边的元素比中心点更小, 则需要对换一下
      nums[l] = nums[r];
      // 换完以后, l元素已经备份下来, 继续左边的比较
      while (l < r && p >= nums[l]) {
        l++;
      }
      // 跳出以后说明右边的元素比中枢更大了, 继续对换一下
      nums[r] = nums[l];
      // 这一圈就完了, 下一圈继续重复操作, 只不过不是从两个端点开始
    }
    // 重复的这个点就确定是p点的位置
    nums[r] = p;
    // 跳出循环以后这一轮的就基本有序了, 剩下的就是分而治之
    quick(nums, left, r - 1);
    quick(nums, l + 1, right);

  }

}
