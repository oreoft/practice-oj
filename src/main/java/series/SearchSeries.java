package series;

/**
 * 查找题
 *
 * @author zyf
 * @date 2021-11-16 08:11
 */
public class SearchSeries {

  /**
   * 二分查找, 查找给定值的下标
   * @param nums 待查数组
   * @param key 待查key
   * @return 返回的下标, 如果没查到返回-1
   */
  public static int binarySearch(int[] nums, int key) {
    // 进来先判空
    if (nums == null || nums.length == 0) {
      return -1;
    }
    // 把两端坐标记录
    int low = 0, high = nums.length - 1;
    // 如果头和尾不相等, 则一直遍历
    while (low <= high) {
      // 把中间值记录到
      int mid = (low + high) / 2;
      // 如果中间值恰好是查找值, 则直接返回
      if (nums[mid] == key) {
        return mid;
      }
      // 如果本次中间值比key更大, 则在下一轮中把头调大一位
      if (nums[mid] < key) {
        low = mid + 1;
      } else {
        // 反之亦然
        high = mid - 1;
      }
    }
    // 最后没有查到, 返回-1
    return -1;
  }

}
