import org.junit.jupiter.api.Test;
import series.LinkedSeries;
import series.SearchSeries;
import series.SortSeries;
import unit.ListNode;

import java.util.Arrays;

import static unit.InputTools.initListNode;

/**
 *  方便测试的入口方法
 *  已经弃用, 还是直接在series里面写方便一些😂
 * @author oreft
 */
public class CaseTest {

    /**
     * 初始化样例
     */
    public static ListNode l1 = initListNode("[4, 8, 9, 11]");
    public static ListNode l2 = initListNode("[-9, 5, 6, 7]");
    public static int[] nums = {2, 5, -8, 6, 5, 9, 1};
    public static int[] sortedNums = {1, 5, 6, 14, 19, 20};


    @Test
    public void linked() {
        System.out.println(LinkedSeries.mergeTwoListsRecursion(l1, l2));
    }

    @Test
    public void sorted() {
        System.out.println(Arrays.toString(SortSeries.quickSort(nums)));
    }

    @Test
    public void search() {
        System.out.println(SearchSeries.binarySearch(sortedNums, 14));
    }

    @Test
    public void reverseList() {
        System.out.println(LinkedSeries.reverseList(l1));
    }


}
